package com.example.internshipraionteam2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.data.network.SharedViewModel
import com.example.internshipraionteam2.presentation.home.HomeScreenApplicants
//import com.example.internshipraionteam2.presentation.home.HomeScreenCafe
import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
import com.example.internshipraionteam2.presentation.home.BottomScreenApplicants
import com.example.internshipraionteam2.presentation.home.EditProfileScreen
import com.example.internshipraionteam2.presentation.home.ExperienceInformationScreen
import com.example.internshipraionteam2.presentation.home.FolderScreen
import com.example.internshipraionteam2.presentation.home.InformationAccountScreen
import com.example.internshipraionteam2.presentation.home.Lamaran
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
import com.example.internshipraionteam2.presentation.registration.screen.cafe.RegisterScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.SignupScreenCafe
import com.example.internshipraionteam2.presentation.registration.screen.cafe.SummaryScreenCafe

@Composable
fun UserNavigation(modifier: Modifier, authViewModel: AuthViewModel, sharedViewModel: SharedViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "UserOption", builder = {
        composable("UserOption"){
            UserOption(navController, authViewModel)
        }
//        composable("ApplicantsNavigation"){
//            ApplicantsNavigation(authViewModel,sharedViewModel)
//        }
        composable("LoginScreenApplicants"){
            LoginScreenApplicants(navController,authViewModel)
        }
        composable("LoginScreenCafe"){
            LoginScreenCafe(navController,authViewModel)
        }
        composable("HomeScreenCafe"){
//            HomeScreenCafe(navController)
        }
        composable("BottomScreenApplicants"){
            BottomScreenApplicants(navController, authViewModel)
        }
        composable("SignupScreenApplicants"){
            SignupScreenApplicants(navController,authViewModel)
        }
        composable("SignupScreenCafe"){
            SignupScreenCafe(navController)
        }
        composable("RegisterScreenApplicants"){
            RegisterScreenApplicants(navController, sharedViewModel = SharedViewModel())
        }
        composable("RegisterScreenCafe"){
            RegisterScreenCafe(navController, sharedViewModel = SharedViewModel())
        }
        composable("GreetingScreenApplicants"){
            GreetingScreenApplicants(navController)
        }
        composable("GreetingScreenCafe"){
            GreetingScreenCafe(navController)
        }
        composable("CvScreenApplicants"){
           CvScreenApplicants(navController)
        }
        composable("CvScreenCafe"){
           CvScreenCafe(navController)
        }
        composable("CertificateScreenApplicants"){
            CertificateScreenApplicants(navController)
        }
        composable("CertificateScreenCafe"){
            CertificateScreenCafe(navController)
        }
        composable("SummaryScreenApplicants"){
            SummaryScreenApplicants(navController)
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
        composable("WorkDetail"){
            WorkDetail(navController)
        }
    })
}