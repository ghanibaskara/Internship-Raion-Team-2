package com.example.internshipraionteam2.presentation.home.screen

import androidx.compose.foundation.Image

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.ViewModel.AuthViewModel
import com.example.internshipraionteam2.data.Firebase.ViewModel.ApplicantsViewModel
import com.example.internshipraionteam2.presentation.home.elements.EventCard
import com.example.internshipraionteam2.presentation.home.elements.NewsCard
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Composable
fun HomeScreenApplicants(
    navController: NavController,
    authViewModel: AuthViewModel,
    applicantsViewModel: ApplicantsViewModel = viewModel()
) {

//    LaunchedEffect(authState.value) {
//        val state = authState.value
//        if (state == null) return@LaunchedEffect // Pastikan tidak `null`
//
//        if (state is AuthState.Unauthenticated) {
//            navController.navigate("UserOption") {
//                popUpTo("HomeScreenApplicants") { inclusive = true } // Mencegah navigasi berulang
//            }
//        }
//    }
//    LaunchedEffect(authState.value) {
//        when (authState.value) {
//            is AuthState.Unauthenticated -> navController.navigate("UserOption")
//            else -> Unit
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(Color.White) // hanya untuk preview
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(94.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom) {
                    Text("Hi, ",
                        fontFamily = localFontFamily,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold)
                    Text(applicantsViewModel.applicantData.fname + "\uD83D\uDC4B\uD83C\uDFFB",
                        fontFamily = localFontFamily,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold)

                }

                Text("Mari mulai bekerja di kafe impianmu!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = localFontFamily
                )
            }

            Icon(painter = painterResource(R.drawable.ic_bell), contentDescription = "")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            onClick = {authViewModel.signout()},
            modifier = Modifier
                .fillMaxWidth()
                .height(156.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(color = Color(0xFF6F4A31))
                    .padding(horizontal = 14.dp, vertical = 16.dp)
            ) {
            Row(
                modifier = Modifier.height(50.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
            Icon(painter = painterResource(R.drawable.ellipse_filled), contentDescription = "",
                modifier = Modifier.size(50.dp))

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Dekker Koffie",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W700)
                Text("Lowokwaru",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W400)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
            Text("Barista",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W700)

                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Rp5 juta/bulan",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W700)
                    Box(contentAlignment = Alignment.Center){
                        Icon(painter = painterResource(R.drawable.ellipse_4), contentDescription = "",
                            tint = Color.Unspecified, modifier = Modifier.size(20.dp))
                        Icon(painter = painterResource(R.drawable.ic_arrow_right), contentDescription = "",
                            tint = buttonfocus)
                    }

                }
            }


            Spacer(modifier = Modifier.height(12.dp))

            Row() {
            Icon(painter = painterResource(R.drawable.tag_fulltime), contentDescription = "",
                tint = Color.White)
            }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Event",
            fontSize = 20.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W700)

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
        ) {
            items(applicantsViewModel.cafeid.value.cafeUid){
                cafeuid ->
                EventCard(modifier = Modifier,cafeuid)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Berita",
            fontSize = 20.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W700)

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
        ) {
            items(5){
                NewsCard()
            }
        }

    }
}




