package com.example.internshipraionteam2.reusable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.localFontFamily


@Composable
fun HistoryCard(text: String
,navController: NavController) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.fillMaxWidth()
            .height(185.dp)
            .padding(bottom = 10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(com.example.internshipraionteam2.ui.theme.buttonfocus)
                .padding(start = 16.dp, end = 16.dp, top = 4.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text("Lamaran $text",
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 20.sp,
                color = Color.White)

            Spacer(modifier = Modifier.height(3.dp))

            Text("Cafe Laluna Space",
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.White)

            Spacer(modifier = Modifier.height(4.dp))

            Spacer(modifier = Modifier.height(3.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(R.drawable.ic_calendar),
                    contentDescription = "",
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(6.dp))

                Text("Tanggal melamar: 10 Maret 2025",
                    fontWeight = FontWeight.W600,
                    fontFamily = localFontFamily,
                    fontSize = 12.sp,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(R.drawable.ic_briefcase),
                    contentDescription = "",
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(6.dp))

                Text("Posisi yang dilamar: Barista",
                    fontWeight = FontWeight.W600,
                    fontFamily = localFontFamily,
                    fontSize = 12.sp,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(R.drawable.ic_location),
                    contentDescription = "",
                    tint = Color.White)
                Spacer(modifier = Modifier.width(4.dp))

                Text("Lokasi:Jl. Sigura-gura No.5, Lowokwaru, Malang",
                    fontWeight = FontWeight.W600,
                    fontFamily = localFontFamily,
                    fontSize = 12.sp,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.height(2.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Button(onClick = {
                    navController.navigate("Lamaran")
                }
                , colors = ButtonDefaults.buttonColors(Color.White)) {
                    Text("Cek status lamaran",
                        fontWeight = FontWeight.W600,
                        fontFamily = localFontFamily,
                        fontSize = 12.sp,
                        color = Color.Black)
                }
            }
        }
    }
}