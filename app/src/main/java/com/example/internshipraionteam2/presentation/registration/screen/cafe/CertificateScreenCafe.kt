package com.example.internshipraionteam2.presentation.registration.screen.cafe

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.buttonfocus

@Composable
fun CertificateScreenCafe(
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
            Spacer(modifier = Modifier.width(32.dp))
            Icon(modifier = Modifier.clickable {
                navController.popBackStack()
            },painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "arrow back")
            Spacer(modifier = Modifier.width(80.dp))
            Text("Unggah berkas",
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
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
                    fontWeight = FontWeight.W700,
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
                    fontWeight = FontWeight.W700,
                    color = Color.White)
            }
            Icon(
                painterResource(R.drawable.rectangle_filled),
                contentDescription = "",
                tint = buttonfocus
            )
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painterResource(R.drawable.ellipse_25),
                    contentDescription = "",
                    tint = buttonfocus
                )
                Text(text = "3",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W700)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Sertifikasi*",
            fontSize = 24.sp,
            fontWeight = FontWeight.W700)

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
            horizontalAlignment = Alignment.Start) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(149.dp)
                .clickable { }){
                Icon(
                    painterResource(R.drawable.rectangle_796),
                    contentDescription = "Cv column")
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(R.drawable.ic_add_circle),
                        contentDescription = "add circle",
                        modifier = Modifier.size(56.dp))
                    Text(text = "Unggah berkas sertifikasi/lisensi Anda",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text("*Ketentuan berkas sertifikasi",
                fontSize = 14.sp,
                fontWeight = FontWeight.W700)

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ellipse_28),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text("Opsional (tidak wajib ada)",
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ellipse_28),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text("Format berkas: PDF",
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ellipse_28),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text("Format nama berkas: Nama lengkap_sertifikasi.pdf",
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ellipse_28),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text("Ukuran berkas maksimum: 5Mb",
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(134.dp))
        }
        Button(onClick = {
            navController.navigate("SummaryScreenCafe")
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .size(width = 0.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonfocus)
        ) {
            Text("Selanjutnya",
                fontSize = 14.sp,
                fontWeight = FontWeight.W600)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                navController.navigate("HomeScreenCafe")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            Text(text = "Lewati",
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = Color(0x61000000)
            )
        }
    }
}