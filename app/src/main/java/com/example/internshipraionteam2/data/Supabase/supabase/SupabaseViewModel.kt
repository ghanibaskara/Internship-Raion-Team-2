package com.example.internshipraionteam2.data.Supabase.supabase

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshipraionteam2.data.Supabase.supabase.SupabaseClient.client
import com.example.internshipraionteam2.data.Supabase.supabase.model.UserState
import com.example.internshipraionteam2.data.Supabase.supabase.utils.SharedPreferenceHelper
import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.storage.storage
import io.github.jan.supabase.storage.upload
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.minutes

class SupabaseViewModel : ViewModel() {
    private val _userState = mutableStateOf<UserState>(UserState.Loading)
    val userState: State<UserState> = _userState

    fun createBucket(name: String){
        try {
            viewModelScope.launch {
                _userState.value = UserState.Loading
                client.storage.createBucket(id = name) {
                    public = true
                    fileSizeLimit = 10.megabytes
                }
                _userState.value = UserState.Success("Created bucket successfully")
        }
        } catch (e: Exception){
            _userState.value = UserState.Error("Error: ${e.message}")
        }
    }

    fun uploadFIle(bucketName: String,fileName: String, byteArray: ByteArray){
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                val bucket = client.storage[bucketName]
                bucket.upload("$fileName.pdf", byteArray, true)
                _userState.value = UserState.Success("Berkas berhasil diupload.")
            } catch (e: Exception){
                _userState.value = UserState.Error("Error: ${e.message  }")
            }
        }
    }

    fun readFile(
        bucketName: String,
        fileName: String,
        onImageUrRetrieved: (url: String) -> Unit
    ){
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                val bucket = client.storage[bucketName]
                val url = bucket.publicUrl("$fileName.jpg")
                onImageUrRetrieved(url)
                _userState.value = UserState.Success("Berkas berhasil dibaca.")
            } catch (e: Exception){
                _userState.value = UserState.Error("Error: ${e.message}")
            }
        }
    }

    fun getFileUrl(bucketName: String, fileName: String): String {
        // Mengambil URL publik untuk file yang diunggah
        val bucket = client
        return bucket.storage.from(bucketName).publicUrl(fileName)
    }

}