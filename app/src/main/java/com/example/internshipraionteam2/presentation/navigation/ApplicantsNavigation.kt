//package com.example.internshipraionteam2.presentation.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
//import com.example.internshipraionteam2.data.network.SharedViewModel
//import com.example.internshipraionteam2.presentation.home.HomeScreenApplicants
//import com.example.internshipraionteam2.presentation.home.HomeScreenCafe
//import com.example.internshipraionteam2.presentation.registration.screen.UserOption
//import com.example.internshipraionteam2.presentation.registration.screen.applicants.CertificateScreenApplicants
//import com.example.internshipraionteam2.presentation.registration.screen.applicants.CvScreenApplicants
//import com.example.internshipraionteam2.presentation.registration.screen.applicants.GreetingScreenApplicants
//import com.example.internshipraionteam2.presentation.registration.screen.applicants.LoginScreenApplicants
//import com.example.internshipraionteam2.presentation.registration.screen.applicants.RegisterScreenApplicants
//import com.example.internshipraionteam2.presentation.registration.screen.applicants.SignupScreenApplicants
//import com.example.internshipraionteam2.presentation.registration.screen.applicants.SummaryScreenApplicants
//import com.example.internshipraionteam2.supabase.SupabaseViewModel
//
//
////belum dipake
//
//@Composable
//fun ApplicantsNavigation(authViewModel: AuthViewModel, sharedViewModel: SharedViewModel, supabaseViewModel: SupabaseViewModel) {
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = "LoginScreenApplicants", builder = {
//        composable("UserOption"){
//            UserOption(navController, authViewModel, sharedViewModel)
//        }
//        composable("LoginScreenApplicants"){
//            LoginScreenApplicants(navController,authViewModel,sharedViewModel)
//        }
//        composable("HomeScreenCafe"){
//            HomeScreenCafe(navController)
//        }
//        composable("HomeScreenApplicants"){
//            HomeScreenApplicants(navController, authViewModel, supabaseViewModel)
//        }
//        composable("SignupScreenApplicants"){
//            SignupScreenApplicants(navController,authViewModel,sharedViewModel)
//        }
//        composable("RegisterScreenApplicants"){
//            RegisterScreenApplicants(navController, sharedViewModel = SharedViewModel())
//        }
//        composable("GreetingScreenApplicants"){
//            GreetingScreenApplicants(navController, authViewModel, sharedViewModel)
//        }
//        composable("CvScreenApplicants"){
//            CvScreenApplicants(navController, supabaseViewModel)
//        }
//        composable("CertificateScreenApplicants"){
//            CertificateScreenApplicants(navController)
//        }
//        composable("SummaryScreenApplicants"){
//            SummaryScreenApplicants(navController)
//        }
//    })
//}