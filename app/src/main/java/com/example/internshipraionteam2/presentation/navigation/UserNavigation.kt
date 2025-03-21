package com.example.internshipraionteam2.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.data.Firebase.ViewModel.SharedViewModel
//import com.example.internshipraionteam2.presentation.home.HomeScreenCafe
import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
import com.example.internshipraionteam2.presentation.home.AboutUsScreen
import com.example.internshipraionteam2.presentation.home.BottomScreenApplicants
import com.example.internshipraionteam2.presentation.home.ChatScreen
import com.example.internshipraionteam2.presentation.home.EditProfileScreen
import com.example.internshipraionteam2.presentation.home.ExperienceInformationScreen
import com.example.internshipraionteam2.presentation.home.FolderScreen
import com.example.internshipraionteam2.presentation.home.HelpCenter
import com.example.internshipraionteam2.presentation.home.InformationAccountScreen
import com.example.internshipraionteam2.presentation.home.Lamaran
import com.example.internshipraionteam2.presentation.home.PassChangeScreen
import com.example.internshipraionteam2.presentation.home.ProfileScreenApplicants
import com.example.internshipraionteam2.presentation.home.SecurityPrivacyScreen
import com.example.internshipraionteam2.presentation.home.WorkDetail
import com.example.internshipraionteam2.presentation.registration.screen.UserOption
import com.example.internshipraionteam2.presentation.registration.screen.applicants.CertificateScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.applicants.CvScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.applicants.GreetingScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.applicants.LoginScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.applicants.RegisterScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.applicants.SignupScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.applicants.SummaryScreenApplicants
import com.example.internshipraionteam2.presentation.registration.screen.cafe.CertificateScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.CvScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.GreetingScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.LoginScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.SignupScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.SummaryScreenCafe
import com.example.internshipraionteam2.data.Supabase.supabase.SupabaseViewModel

@Composable
fun UserNavigation(modifier: Modifier, authViewModel: AuthViewModel, sharedViewModel: SharedViewModel, supabaseViewModel: SupabaseViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "UserOption", builder = {
        composable("UserOption"){

            UserOption(navController, authViewModel, sharedViewModel)
        }
//        composable("ApplicantsNavigation"){
//            ApplicantsNavigation(authViewModel,sharedViewModel, supabaseViewModel)

//        }
        composable("LoginScreenApplicants"){
            LoginScreenApplicants(navController,authViewModel)
        }
        composable("LoginScreenCafe"){
            LoginScreenCafe(navController,authViewModel,sharedViewModel)
        }
        composable("HomeScreenCafe"){

//            HomeScreenCafe(navController,authViewModel,sharedViewModel)
        }
        composable("BottomScreenApplicants"){
//            HomeScreenApplicants(navController, authViewModel, supabaseViewModel,sharedViewModel)
BottomScreenApplicants(navController,authViewModel)
        }
        composable("SignupScreenApplicants"){
            SignupScreenApplicants(navController,authViewModel)
        }
        composable("SignupScreenCafe"){
            SignupScreenCafe(navController, authViewModel,sharedViewModel)
        }
        composable("RegisterScreenApplicants"){
            RegisterScreenApplicants(navController)
        }
        composable("RegisterScreenCafe"){
//            RegisterScreenCafe(navController, sharedViewModel = SharedViewModel())
        }
        composable("GreetingScreenApplicants"){
            GreetingScreenApplicants(navController, authViewModel)
        }
        composable("GreetingScreenCafe"){
            GreetingScreenCafe(navController)
        }
        composable("CvScreenApplicants"){
           CvScreenApplicants(navController, supabaseViewModel,sharedViewModel)
        }
        composable("CvScreenCafe"){
           CvScreenCafe(navController)
        }
        composable("CertificateScreenApplicants"){
            CertificateScreenApplicants(navController,supabaseViewModel,sharedViewModel)
        }
        composable("CertificateScreenCafe"){
            CertificateScreenCafe(navController)
        }
        composable("SummaryScreenApplicants"){
            SummaryScreenApplicants(navController, sharedViewModel)
        }
        composable("SummaryScreenCafe"){
            SummaryScreenCafe(navController)
        }
        composable("ProfileScreenApplicants"){
            ProfileScreenApplicants(navController)
        }
        composable("InformationAccountScreen"){
            InformationAccountScreen(navController)
        }
        composable("EditProfileScreen"){
            EditProfileScreen(navController)
        }
        composable("ExperienceInformationScreen"){
            ExperienceInformationScreen(navController)
        }
        composable("SecurityPrivacyScreen"){
            SecurityPrivacyScreen(navController)
        }
        composable("Lamaran"){
            Lamaran(navController)
        }
        composable("FolderScreen"){
            FolderScreen(navController)
        }
        composable("WorkDetail/{cafeUid}"){
            backStackEntry ->
            val cafeUid = backStackEntry.arguments?.getString("cafeUid") ?: ""
            WorkDetail(navController,cafeUid)
        }
        composable("AboutUsScreen"){
            AboutUsScreen(navController)
        }
        composable("HelperScreen"){
            HelpCenter(navController)
        }
        composable("PassChangeScreen"){
            PassChangeScreen(navController)
        }
        composable("ChatScreen"){
            ChatScreen(navController)
        }
    })
}