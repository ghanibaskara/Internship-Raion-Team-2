package com.example.internshipraionteam2.presentation.registration.screen.applicants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily


@Composable
fun GreetingScreenApplicants(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Icon(painterResource(R.drawable.coffe_person),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.padding(top = 267.dp))

        Spacer(modifier = Modifier.height(32.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            Text("Langkah pertama",
                fontSize = 28.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold)

        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            Text("menuju kesuksesan",
                fontSize = 28.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text("Lengkapi biodata sekarang dan temukan",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text("pekerjaan sesuai preferensi Anda!",
                fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(78.dp))

        Button(onClick = {
            navController.navigate("RegisterScreenApplicants")
        },
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 0.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonfocus)
        ) {
            Text("Mulai",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                navController.navigate("HomeScreenApplicants")
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            Text(text = "Lewati",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0x61000000)
            )
        }
    }
}