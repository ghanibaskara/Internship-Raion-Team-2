package com.example.internshipraionteam2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.internshipraionteam2.data.network.SharedViewModel
import com.example.internshipraionteam2.presentation.navigation.UserNavigation
import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
import com.example.internshipraionteam2.supabase.SupabaseViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        val sharedViewModel : SharedViewModel by viewModels()
        val supabaseViewModel : SupabaseViewModel by viewModels()
        setContent {
            Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->
                UserNavigation(modifier = Modifier.padding(innerPadding),
                    authViewModel = authViewModel, sharedViewModel = sharedViewModel, supabaseViewModel)
            }
        }    }
}