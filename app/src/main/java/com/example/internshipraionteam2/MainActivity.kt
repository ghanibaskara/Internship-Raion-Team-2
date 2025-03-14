package com.example.internshipraionteam2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.data.ViewModel.AuthState
import com.example.internshipraionteam2.data.network.SharedViewModel
import com.example.internshipraionteam2.presentation.navigation.UserNavigation
import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        val sharedViewModel : SharedViewModel by viewModels()
        setContent {
            Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->
                UserNavigation(modifier = Modifier.padding(innerPadding),
                    authViewModel = authViewModel, sharedViewModel = sharedViewModel)
            }
        }
    }
}