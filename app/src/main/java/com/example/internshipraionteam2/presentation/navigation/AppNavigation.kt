package com.example.internshipraionteam2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.presentation.home.HomeScreenApplicants
import com.example.internshipraionteam2.presentation.home.HomeScreenCafe
import com.example.internshipraionteam2.presentation.registration.AuthViewModel
import com.example.internshipraionteam2.presentation.registration.screen.UserOption
import com.example.internshipraionteam2.presentation.registration.screen.applicants.LoginScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.applicants.RegisterScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.applicants.SignupScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.cafe.LoginScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.RegisterScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.SignupScreenCafe

@Composable
fun AppNavigation(modifier: Modifier,authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "UserOption", builder = {
        composable("UserOption"){
            UserOption(navController)
        }
        composable("LoginScreenApplicants"){
            LoginScreenApplicants(navController,authViewModel)
        }
        composable("LoginScreenCafe"){
            LoginScreenCafe(navController,authViewModel)
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
            RegisterScreenApplicants(navController)
        }
        composable("RegisterScreenCafe"){
            RegisterScreenCafe(navController)
        }
    })
}