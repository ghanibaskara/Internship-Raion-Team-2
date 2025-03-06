package com.example.internshipraionteam2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.ui.theme.InternshipRaionTeam2Theme
import com.example.internshipraionteam2.presentation.home.HomeScreenApplicants
import com.example.internshipraionteam2.presentation.home.HomeScreenCafe
import com.example.internshipraionteam2.presentation.registration.AppNavigation
import com.example.internshipraionteam2.presentation.registration.AuthViewModel
import com.example.internshipraionteam2.presentation.registration.LoginScreenApplicants
import com.example.internshipraionteam2.presentation.registration.LoginScreenCafe
import com.example.internshipraionteam2.presentation.registration.RegisterScreenApplicants
import com.example.internshipraionteam2.presentation.registration.RegisterScreenCafe
import com.example.internshipraionteam2.presentation.registration.SignupScreenApplicants
import com.example.internshipraionteam2.presentation.registration.SignupScreenCafe
import com.example.internshipraionteam2.presentation.registration.UserOption

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        setContent {
            Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->
                AppNavigation(modifier = Modifier.padding(innerPadding),
                    authViewModel = authViewModel)
            }
        }
    }
}