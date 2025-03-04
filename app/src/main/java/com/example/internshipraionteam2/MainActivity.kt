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
            val navController = rememberNavController()

            NavHost(navController, startDestination = "UserOption", builder = {
                composable("UserOption"){
                    UserOption(navController)
                }
                composable("LoginScreenApplicants"){
                    LoginScreenApplicants(navController, authViewModel)
                }
                composable("LoginScreenCafe"){
                    LoginScreenCafe(navController)
                }
                composable("HomeScreenCafe"){
                    HomeScreenCafe(navController)
                }
                composable("HomeScreenApplicants"){
                    HomeScreenApplicants(navController)
                }
                composable("SignupScreenApplicants"){
                    SignupScreenApplicants(navController,authViewModel)
                }
                composable("SignupScreenCafe"){
                    SignupScreenCafe(navController)
                }
                composable("RegisterScreenApplicants"){
                    RegisterScreenApplicants()
                }
                composable("RegisterScreenCafe"){
                    RegisterScreenCafe()
                }

            })


        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InternshipRaionTeam2Theme {
        Greeting("Android")
    }
}