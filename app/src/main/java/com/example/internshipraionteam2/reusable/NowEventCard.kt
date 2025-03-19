package com.example.internshipraionteam2.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Preview
@Composable
fun NowEventCard() {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.height(237.dp)
            .width(368.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(painter = painterResource(R.drawable.dummy_barista), contentDescription = "",
                    modifier = Modifier.height(205.dp)
                        .width(150.dp))

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        "Flow & Grow: Optimasi Workflow untuk Produktivitas Maksimal",
                        fontWeight = FontWeight.W600,
                        fontFamily = localFontFamily,
                        fontSize = 14.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Row() {
                        Icon(painter = painterResource(R.drawable.ic_cafe), contentDescription = "",
                            tint = Color.Unspecified)

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            "Craft Cafe",
                            fontWeight = FontWeight.W400,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

                    Row() {
                        Icon(painter = painterResource(R.drawable.ic_location), contentDescription = "",
                            tint = Color.Unspecified)

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            "Lowokwaru, Malang",
                            fontWeight = FontWeight.W400,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

                    Row() {
                        Icon(painter = painterResource(R.drawable.ic_clock), contentDescription = "",
                            tint = Color.Unspecified)

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            "13.00-selesai",
                            fontWeight = FontWeight.W400,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
//                        modifier = Modifier.height(20.dp)
                    ) {
                        Icon(painter = painterResource(R.drawable.tag_briefcase),
                            contentDescription = "",
                            tint = Color.Unspecified)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(painter = painterResource(R.drawable.tag_seminar),
                            contentDescription = "",
                            tint = Color.Unspecified)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64906)),
                        modifier = Modifier.width(164.dp)) {
                        Text(
                            "Lihat detail",
                            fontWeight = FontWeight.W600,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = com.example.internshipraionteam2.ui.theme.buttonfocus
                        )
                    }
                }
            }
        }
    }
}