package com.example.internshipraionteam2.data.network

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.content.Context
import android.util.Log
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewModelScope
import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await


class SharedViewModel() : ViewModel() {
    val state = mutableStateOf(UserData())
    val auth = FirebaseAuth.getInstance().currentUser
    var uid = auth?.uid ?: ""
    var currentUid: String = ""
    var accountType: String = ""
    var email: String = "asd"
    var biodataIsFilled: Boolean = false
    var isLoading = false

    init {
        getData()
    }

    fun getAccountTypeData(
        data: (AccountTypeData) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        val fireStoreRef = Firebase.firestore
            .collection("account")
            .document(uid).get().await()

        val accountTypeData = fireStoreRef.toObject<AccountTypeData>()!!
        data(accountTypeData)

    }

    private fun getData() {
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }


    //bakalan dihapus
    fun saveApplicantsBiodata(
        userData: UserData,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("biodata")
            .document(uid ?: "")

        try {

            fireStoreRef.set(userData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Data berhasil disimpan.", Toast.LENGTH_SHORT)
                        .show()
                }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }


    //bakal dihapus atau dimodifikasi
    fun saveCafeData(
        cafeDetails: CafeDetails,
        context: Context
    )  {

        val fireStoreRef = Firebase.firestore
            .collection("cafeDetails")
            .document(uid ?: "")

        try {
            fireStoreRef.set(cafeDetails)
                .addOnSuccessListener {
                    Toast.makeText(context, "Data berhasil disimpan.", Toast.LENGTH_SHORT)
                        .show()
                }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }



    fun saveAppliedApplicantsUid(uid: String, cafeuid: String) {
        val documentRef = Firebase.firestore.collection("cafeDetails").document(cafeuid)

        // Menggunakan arrayUnion untuk menambahkan UID ke field array
        documentRef.update("applicants", FieldValue.arrayUnion(uid))

    }

    fun getAllCafeIds(onResult: (cafeId) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Ambil semua dokumen dari koleksi cafeDetails
                val documents = Firebase.firestore.collection("cafeDetails").get().await()
                val cafeIds = cafeId(
                    cafeUid = documents.documents.map { it.id }.toSet()
                        .toMutableList()
                ) // Mengambil ID dokumen dan mengonversinya menjadi list

                // Mengembalikan hasil ke UI thread
                onResult(cafeIds)
            } catch (e: Exception) {
                // Tangani kesalahan
                e.printStackTrace()
            }
        }
    }


    fun saveAccountTypeData(
        accountTypeData: AccountTypeData,
        context: Context,
        uid: String
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("account")
            .document(uid)

        try {

            fireStoreRef.set(accountTypeData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Data berhasil disimpan.", Toast.LENGTH_SHORT)
                        .show()
                }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun getApplicantsData(
        data: (UserData) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {
        var isLoading = true
        val fireStoreRef = Firebase.firestore
            .collection("biodata")
            .document(uid ?: "").get().await()

        val userData = fireStoreRef.toObject<UserData>()!!
        data(userData)
    }
}


suspend fun getDataFromFireStore(): UserData { // function untuk return data class userData
    val db = FirebaseFirestore.getInstance()
    var biodata = UserData()

    try { // untuk request di dalam firestore
        db.collection("biodata").get().await()
            .map { // collection digunakan untuk menentukan collecton mana yang akan di ambil
                val result =
                    it.toObject(UserData::class.java) // digunakan untuk mapping result ke data class
                biodata = result
            }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")
    }

    return biodata
}