package com.example.internshipraionteam2.presentation.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.reusable.HistoryCard
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily
import java.lang.reflect.Modifier

@Preview
@Composable
fun Lamaran() {
    Column(modifier = androidx.compose.ui.Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(start = 32.dp, end = 32.dp, top = 64.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top) {
        Row(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = androidx.compose.ui.Modifier.clickable {
//                navController.popBackStack()
                }, painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "",
                tint = Color.Black
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(70.dp))
            Text(
                "Lamaran 1",
                fontWeight = FontWeight.W700,
                fontFamily = localFontFamily,
                fontSize = 28.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(44.dp))
        Text(
            "Cafe Laluna Space",
            fontWeight = FontWeight.W600,
            fontFamily = localFontFamily,
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = androidx.compose.ui.Modifier.height(5.dp))

        Row(modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(R.drawable.ic_briefcase),
                contentDescription = "",
                tint = Color.Black
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(6.dp))

            Text(
                "Posisi yang dilamar: Barista",
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(2.dp))

        Row(modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = "",
                tint = Color.Black
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(4.dp))

            Text(
                "Lokasi:Jl. Sigura-gura No.5, Lowokwaru, Malang",
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(2.dp))

        Text(
            "Sebagai Barista, Anda akan bertanggung jawab untuk meracik dan menyajikan kopi serta minuman lainnya dengan kualitas terbaik. Selain itu, Anda juga akan berinteraksi dengan pelanggan untuk memberikan pengalaman layanan yang ramah dan menyenangkan.",
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            fontSize = 12.sp,
            color = Color.Black
        )

        Spacer(modifier = androidx.compose.ui.Modifier.height(9.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Status",
                fontWeight = FontWeight.W700,
                fontFamily = localFontFamily,
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                "lamaran",
                fontWeight = FontWeight.W700,
                fontFamily = localFontFamily,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
        Row(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "Tahap 1",
                fontWeight = FontWeight.W500,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                "Tahap 2",
                fontWeight = FontWeight.W500,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                "Tahap 3",
                fontWeight = FontWeight.W500,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                "Tahap 4",
                fontWeight = FontWeight.W500,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))
        Row(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = androidx.compose.ui.Modifier.width(40.dp))
            Icon(painter = painterResource(R.drawable.ellipse_4), contentDescription = "",
                tint = Color.Unspecified,
                modifier = androidx.compose.ui.Modifier.size(20.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(55.dp))
            Icon(painter = painterResource(R.drawable.ellipse_4), contentDescription = "",
                tint = Color.Unspecified,
                modifier = androidx.compose.ui.Modifier.size(20.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(58.dp))
            Icon(painter = painterResource(R.drawable.ellipse_4), contentDescription = "",
                tint = Color.Unspecified,
                modifier = androidx.compose.ui.Modifier.size(20.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(59.dp))
            Icon(painter = painterResource(R.drawable.ellipse_4), contentDescription = "",
                tint = buttonfocus,
                modifier = androidx.compose.ui.Modifier.size(20.dp)
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(7.dp))

        Row(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = androidx.compose.ui.Modifier.width(25.dp))

            Text(
                "terkirim",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(33.dp))

            Text(
                "ditinjau",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(30.dp))
            Text(
                "Interview",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = androidx.compose.ui.Modifier.width(37.dp))
            Text(
                "Hasil",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(36.dp))
        Text(
            "Waktu lamaran:",
            fontWeight = FontWeight.W600,
            fontFamily = localFontFamily,
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(13.dp))
        Row() {
            Icon(painter = painterResource(R.drawable.ic_clock), contentDescription = "")
            Spacer(modifier = androidx.compose.ui.Modifier.width(4.dp))
            Text(
                "10 Maret 2025:",
                fontWeight = FontWeight.W500,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))
        Text(
            "Anda mendaftar di Cafe Laluna Space",
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            fontSize = 14.sp,
            color = Color.Black
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))

        Row() {
            Icon(painter = painterResource(R.drawable.ic_clock), contentDescription = "")
            Spacer(modifier = androidx.compose.ui.Modifier.width(4.dp))
            Text(
                "11 Maret 2025:",
                fontWeight = FontWeight.W500,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))
        Text(
            "Lamaran anda telah ditinjau dan diterima pihak kafe",
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            fontSize = 14.sp,
            color = Color.Black
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))

        Row() {
            Icon(painter = painterResource(R.drawable.ic_clock), contentDescription = "")
            Spacer(modifier = androidx.compose.ui.Modifier.width(4.dp))
            Text(
                "11 Maret 2025:",
                fontWeight = FontWeight.W500,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))
        Text(
            "Anda dijadwalkan untuk interview pada tanggal 13-03-2025",
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            fontSize = 14.sp,
            color = Color.Black
        )
        Row() {
            Icon(painter = painterResource(R.drawable.ic_clock), contentDescription = "")
            Spacer(modifier = androidx.compose.ui.Modifier.width(4.dp))
            Text(
                "15 Maret 2025:",
                fontWeight = FontWeight.W500,
                fontFamily = localFontFamily,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))
        Text(
            "Pengumuman hasil lamaran",
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            fontSize = 14.sp,
            color = Color.Black
        )
        Row(
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = androidx.compose.ui.Modifier.height(117.dp)
                    .width(180.dp)
                    .clickable {  },
                colors = CardDefaults.cardColors(containerColor = Color(0xFF64906))
            ) {
                Column(modifier = androidx.compose.ui.Modifier.fillMaxSize()
                    .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "Status",
                        fontWeight = FontWeight.W600,
                        fontFamily = localFontFamily,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Text(
                        "Lamaran",
                        fontWeight = FontWeight.W600,
                        fontFamily = localFontFamily,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Text(
                        "Lamaran diterima",
                        fontWeight = FontWeight.W600,
                        fontFamily = localFontFamily,
                        fontSize = 12.sp,
                        color = Color(0xFF43936C)
                    )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))
                    Text(
                        "Selamat! anda dinyatakan ",
                        fontWeight = FontWeight.W600,
                        fontFamily = localFontFamily,
                        fontSize = 10.sp,
                        color = Color.Black
                    )
                    Text(
                        "telah diterima",
                        fontWeight = FontWeight.W600,
                        fontFamily = localFontFamily,
                        fontSize = 10.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}