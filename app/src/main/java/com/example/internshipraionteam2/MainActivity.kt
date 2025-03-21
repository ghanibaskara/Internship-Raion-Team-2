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

import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.internshipraionteam2.data.Firebase.ViewModel.SharedViewModel
import com.example.internshipraionteam2.presentation.navigation.UserNavigation
import com.example.internshipraionteam2.data.Firebase.ViewModel.AuthViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import com.example.internshipraionteam2.data.Supabase.supabase.SupabaseViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        val sharedViewModel : SharedViewModel by viewModels()

        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {true}

        CoroutineScope(Dispatchers.Main).launch{
            delay(1000)
            splashScreen.setKeepOnScreenCondition{false}
        }

        val supabaseViewModel : SupabaseViewModel by viewModels()

        setContent {
            Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->
                UserNavigation(modifier = Modifier.padding(innerPadding),
                    authViewModel = authViewModel, sharedViewModel = sharedViewModel, supabaseViewModel)
            }
        }    }
}