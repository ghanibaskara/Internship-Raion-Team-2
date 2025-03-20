package com.example.internshipraionteam2.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
import com.example.internshipraionteam2.data.network.CafeDetails
import com.example.internshipraionteam2.data.network.SharedViewModel
import com.example.internshipraionteam2.presentation.navigation.NavItem
import com.google.firebase.auth.FirebaseAuth


//@Composable
//fun HomeScreenCafe(navController: NavController, authViewModel: AuthViewModel, sharedViewModel: SharedViewModel) {
//
////    val navItemList = listOf(
////        NavItem("Home", Icons.Default.Home),
////        NavItem("Notification", Icons.Default.Notifications),
////        NavItem("Sttings", Icons.Default.Settings)
////    )
//
//    val auth = FirebaseAuth.getInstance().currentUser
//    val uid = auth?.uid ?: ""
//    val email = auth?.email ?: ""
//    var context = LocalContext.current
//
//    val cafeDetails = CafeDetails(
//        uid = uid,
//        email = email
//    )
//
//    var selectedIndex by remember {
//        mutableStateOf(0)
//    }

//    Scaffold(
//        bottomBar = {
//            NavigationBar {
//                navItemList.forEachIndexed { index, navItem ->
//                NavigationBarItem(
//                    selected = selectedIndex == index,
//                    onClick = {
//                        selectedIndex = index},
//                    icon = {
//                        Icon(imageVector = navItem.icon, contentDescription = "Icon")
//                    },
//                    label = {
//                        Text(text = navItem.label)
//                    }
//                )
//                }
//            }
//        }, content =
//            {
//            paddingValues ->
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Button(onClick = { authViewModel.signout() }) { }
//
//                Button(onClick = {
//                    sharedViewModel.saveCafeData(cafeDetails,context)
//                }) {
//                    Text("Daftarkan Cafe")
//                }
//            }
//        }
//    )
//}

