package com.example.internshipraionteam2.data.Firebase.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.internshipraionteam2.data.Firebase.DataClass.AccountTypeData
import com.example.internshipraionteam2.data.Firebase.DataClass.UserData
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()

    val authState: LiveData<AuthState> = _authState

    var currentUserUid: String = auth?.uid ?: ""


    init {
        checkAuthStatus()


    }


    fun checkAuthStatus() {
        if (auth.currentUser == null) {
            _authState.value = AuthState.Unauthenticated
        } else {
            _authState.value = AuthState.Authenticated
        }
    }


    fun login(email: String, password: String) {

        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or password can't be empty.")
            return
        }

        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value =
                        AuthState.Error(task.exception?.message ?: "Something went wrong")
                }
            }
    }

    fun signup(email: String, password: String, accountype: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                    val userId = auth.currentUser?.uid ?: ""
                    while (userId.isEmpty()) {
                    }
                    val db = Firebase.firestore
                    var accountType = AccountTypeData(
                        email = email,
                        uid = userId,
                        accounttype = accountype
                    )
                    db.collection("account").document(userId).set(accountType)
                    var userData = UserData(
                        uid = userId,
                        email = email,
                        biodataisfilled = false
                    )
                    db.collection("biodata").document(userId).set(userData)


                } else {
                    _authState.value =
                        AuthState.Error(task.exception?.message ?: "Something went wrong")
                }
            }

    }


    fun signout() {
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }


}

sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}