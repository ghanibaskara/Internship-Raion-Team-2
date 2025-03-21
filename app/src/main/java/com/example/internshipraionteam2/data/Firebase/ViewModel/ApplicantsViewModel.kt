package com.example.internshipraionteam2.data.Firebase.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshipraionteam2.data.Firebase.DataClass.AppliedTo
import com.example.internshipraionteam2.data.Firebase.DataClass.AppliedToCafes
import com.example.internshipraionteam2.data.Firebase.DataClass.CafeDetails
import com.example.internshipraionteam2.data.Firebase.DataClass.UserData
import com.example.internshipraionteam2.data.Firebase.DataClass.cafeId
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ApplicantsViewModel() : ViewModel(){
    val auth = FirebaseAuth.getInstance().currentUser
    var uid = auth?.uid ?: ""
    val applicantData = UserData(
        fname = "",
        lname = "",
        phone = "",
        dob = "",
        lor = "",
        email = "",
        uid = uid,
        cvurl = "",
        certificateurl = "",
        biodataisfilled = null,
        cvfilename = "",
        certificatefilename = "",
    )

    val cafeDetails = CafeDetails(
        job = "",
        location = "",
        name = "",
        salary = "",
        uid = ""
    )

    var cafeid = mutableStateOf(cafeId())

    var applicationsid = mutableStateOf(AppliedTo())


    init {
        if (uid.isNotEmpty()){
        getApplicantsData {
            data ->
            applicantData.uid = data.uid
            applicantData.fname = data.fname
            applicantData.lname = data.lname
            applicantData.phone = data.phone
            applicantData.dob = data.dob
            applicantData.lor = data.lor
            applicantData.email = data.email
            applicantData.cvurl = data.cvurl
            applicantData.certificateurl = data.certificateurl
            applicantData.biodataisfilled = data.biodataisfilled
            applicantData.certificatefilename = data.certificatefilename
            applicantData.cvfilename = data.cvfilename
        }

            getCafeIds() {
                    result ->
                cafeid.value = cafeId(cafeUid = result.cafeUid.toMutableList())


            }




        }
    }

    fun getApplicantsData(
        data: (UserData) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("biodata")
            .document(uid ?: "").get().await()

        val userData = fireStoreRef.toObject<UserData>()!!
        data(userData)
    }

    fun saveApplicantsBiodata(
        userData: UserData,
        context: Context
    ) = viewModelScope.launch {

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

    fun getCafeIds(onComplete: (cafeId) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val cafeIds = cafeId()

        db.collection("cafeDetails")
            .get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot) {
                    // Menambahkan ID dokumen ke list cafeUid
                    cafeIds.cafeUid.add(document.id)
                }
                onComplete(cafeIds)
            }
            .addOnFailureListener { exception ->
                println("Error mengambil ID cafe: $exception")
                onComplete(cafeId()) // Mengembalikan objek kosong jika terjadi error
            }
    }

    fun getApplicationsDocumentsId( data: (AppliedTo) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val applicationsId = AppliedTo()

        db.collection("ApplicantsApplication").document(uid).collection("applications")
            .get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot) {
                    // Menambahkan ID dokumen ke list cafeUid
                    applicationsId.timestamp.add(document.id)
                }
                data(applicationsId)
            }
            .addOnFailureListener { exception ->
                println("Error mengambil ID cafe: $exception")
                data(AppliedTo()) // Mengembalikan objek kosong jika terjadi error
            }
    }

    fun getApplicationsId(applicationsdocumentid: String, data: (AppliedToCafes) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val applicationsId = AppliedToCafes()

        db.collection("ApplicantsApplication").document(uid).collection("applications").document(applicationsdocumentid)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    // Mengambil field cafeuid dari dokumen
                    val cafeUid = documentSnapshot.getString("cafeuid")
                    if (cafeUid != null) {
                        // Menambahkan cafeuid ke list id
                        applicationsId.id.add(cafeUid)
                    }
                }
                data(applicationsId)
            }
            .addOnFailureListener { exception ->
                println("Error mengambil ID cafe: $exception")
                data(AppliedToCafes()) // Mengembalikan objek kosong jika terjadi error
            }
    }

    fun getCafesData(
        uid: String,
        data: (CafeDetails) -> Unit
    ) = viewModelScope.launch {
        val fireStoreRef = Firebase.firestore
            .collection("cafeDetails")
            .document(uid).get().await()

        val cafeDetails = fireStoreRef.toObject<CafeDetails>()!!
        data(cafeDetails)
    }

    fun saveAppliedApplicantsUid(uid: String, cafeuid: String) {
        val documentRef = Firebase.firestore.collection("cafeDetails").document(cafeuid)

        // Menggunakan arrayUnion untuk menambahkan UID ke field array
        documentRef.update("applicants", FieldValue.arrayUnion(uid))

    }

    fun applicationFunction(
        cafeuid: String,
        position: String,
        cafename: String,
        cafelocations: String

    ) = viewModelScope.launch {
        val calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))
        val tanggalTerformat = formatter.format(calendar.time)
        val documentRef = Firebase.firestore
        val timestamp = System.currentTimeMillis().toString()
        var cafename = cafename
        var cafelocations = cafelocations
        getCafesData(cafeuid){
            data ->
            cafelocations = data.location
            cafename = data.name
        }

        val existingApplicationSnapshot = documentRef.collection("applicantsApplication")
            .document(uid)
            .collection("applications")
            .whereEqualTo("cafeuid", cafeuid)
            .get()
            .await()



        if (existingApplicationSnapshot.isEmpty) {
            // User has not applied to this cafe yet, proceed with application

            // Update the cafe document with the applicant
            documentRef.collection("cafeDetails").document(cafeuid)
                .update("applicants", FieldValue.arrayUnion(uid))


            // For data with unique timestamp
            val applicationData = mapOf(
                "timestamp" to timestamp,
                "applieddate" to tanggalTerformat,
                "appliedforposition" to position,
                "cafeuid" to cafeuid,
                "cafename" to cafename,
                "cafelocations" to cafelocations
            )

            // Save in the "applications" subcollection in the user document
            documentRef.collection("applicantsApplication").document(uid)
                .collection("applications").document(timestamp)
                .set(applicationData)

            // Return success
            Result.success(Unit)
        }
        }
    }


