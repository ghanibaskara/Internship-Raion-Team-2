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
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await



class SharedViewModel(): ViewModel(){
    val state = mutableStateOf(UserData())
    val user = FirebaseAuth.getInstance().currentUser
    val uid = user?.uid


    init { // agar di inisialisasi pertama
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }

    fun saveData(
        userData: UserData,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("biodata")
            .document(uid ?: "")

        try {

            fireStoreRef.set(userData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Data berhasil disimpan.",Toast.LENGTH_SHORT).show()
                }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun saveCafeData(
        cafeDetails: CafeDetails,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("cafeDetails")
            .document(uid ?: "")

        try {
            fireStoreRef.set(cafeDetails)
                .addOnSuccessListener {
                    Toast.makeText(context, "Data berhasil disimpan.",Toast.LENGTH_SHORT).show()
                }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun getAllCafeIds(onResult: (cafeId) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Ambil semua dokumen dari koleksi cafeDetails
                val documents = Firebase.firestore.collection("cafeDetails").get().await()
                val cafeIds = cafeId(cafeUid = documents.documents.map { it.id }.toSet().toMutableList()) // Mengambil ID dokumen dan mengonversinya menjadi list

                // Mengembalikan hasil ke UI thread
                onResult(cafeIds)
            } catch (e: Exception) {
                // Tangani kesalahan
                e.printStackTrace()
            }
        }
    }


    fun saveAccountData(
        accountTypeData: AccountTypeData,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("account")
            .document(uid ?: "")

        try {

            fireStoreRef.set(accountTypeData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Data berhasil disimpan.",Toast.LENGTH_SHORT).show()
                }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun retrieveData(
        context: Context,
        data: (UserData) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("biodata")
            .document(uid ?: "")

        try {

            fireStoreRef.get()
                .addOnSuccessListener {
                    if (it.exists()){
                        val userData = it.toObject<UserData>()!!
                        data(userData)
                    }else{
                        Toast.makeText(context,"No User Data Found", Toast.LENGTH_SHORT).show()
                    }
                }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun retrieveAccountData(
        context: Context,
        data: (AccountTypeData) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("account")
            .document(uid ?: "")
        try {
            fireStoreRef.get()
                .addOnSuccessListener {
                    if (it.exists()){
                        val accountTypeData = it.toObject<AccountTypeData>()!!
                        data(accountTypeData)
                    }else{
                        Toast.makeText(context,"No User Data Found", Toast.LENGTH_SHORT).show()
                    }
                }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}



suspend fun getDataFromFireStore():UserData{ // function untuk return data class userData
    val db = FirebaseFirestore.getInstance()
    var biodata = UserData()

    try { // untuk request di dalam firestore
        db.collection("biodata").get().await().map { // collection digunakan untuk menentukan collecton mana yang akan di ambil
            val result =    it.toObject(UserData::class.java) // digunakan untuk mapping result ke data class
            biodata = result
        }
    }catch (e: FirebaseFirestoreException){
        Log.d("error", "getDataFromFireStore: $e")
    }

    return biodata
}