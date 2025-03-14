package com.example.internshipraionteam2.presentation.registration.screen.applicants

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Composable
fun SummaryScreenApplicants(
    navController: NavController
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(top = 94.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current

        Row(modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            Icon(modifier = Modifier.clickable {
                navController.popBackStack()
            },painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "arrow back")
            Spacer(modifier = Modifier.width(80.dp))
            Text("Unggah berkas",
                fontSize = 20.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painterResource(R.drawable.ellipse_filled),
                    contentDescription = "",
                    tint = buttonfocus
                )
                Text(text = "1",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
            Icon(
                painterResource(R.drawable.rectangle_filled),
                contentDescription = "",
                tint = buttonfocus
            )
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painterResource(R.drawable.ellipse_filled),
                    contentDescription = "",
                    tint = buttonfocus
                )
                Text(text = "2",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
            Icon(
                painterResource(R.drawable.rectangle_filled),
                contentDescription = "",
                tint = buttonfocus
            )
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painterResource(R.drawable.ellipse_filled),
                    contentDescription = "",
                    tint = buttonfocus
                )
                Text(text = "3",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Rangkuman Berkas",
            fontSize = 24.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Biodata",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp)
            Icon(painterResource(R.drawable.ic_arrow_down),
                contentDescription = "")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Curriculum Vitae",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp)
            Icon(painterResource(R.drawable.ic_arrow_down),
                contentDescription = "")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Sertifikasi",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp)
            Icon(painterResource(R.drawable.ic_arrow_down),
                contentDescription = "")
        }

        Spacer(modifier = Modifier.height(333.dp))

        Button(onClick = {
            navController.navigate("HomeScreenApplicants")
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .size(width = 0.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonfocus)
        ) {
            Text("Selanjutnya",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold)
        }
    }
}