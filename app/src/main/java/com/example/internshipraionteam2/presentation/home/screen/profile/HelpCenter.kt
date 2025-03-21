package com.example.internshipraionteam2.presentation.home.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Composable
fun HelpCenter(
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(94.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.clickable {
                navController.navigate("BottomScreenApplicants")
                })
        }

        Spacer(modifier = Modifier.height(23.dp))

        Text(
            "Pusat bantuan",
            fontSize = 28.sp,
            fontWeight = FontWeight.W700,
            fontFamily = localFontFamily,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(36.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
//            .clickable { navController.navigate("InformationAccountScreen") }
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.clickable { expanded = !expanded }
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_user_group),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "Bagaimana daftar/masuk akun?",
                    fontFamily = localFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }
            Icon(
                painter = if (expanded) painterResource(R.drawable.ic_arrow_back) else painterResource(
                    R.drawable.ic_arrow_up
                ),
                contentDescription = "Expand",
                tint = Color.Black
            )
        if (expanded) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Daftar",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily
                )
                Text(
                    text = "1. Pilih Peran (Role): Pihak Kafe atau Pencari Kerja",
                    fontSize = 12.sp,
                    fontFamily = localFontFamily
                )
                Text(
                    text = "2. Masukkan Data Pendaftaran: Email, kata sandi, konfirmasi kata sandi, nama lengkap (pencari kerja) atau nama kafe (employer)",
                    fontSize = 12.sp,
                    fontFamily = localFontFamily
                )
                Text(
                    text = "3. Masukkan file yang diperlukan",
                    fontSize = 12.sp,
                    fontFamily = localFontFamily
                )
            }
        }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
//            .clickable { navController.navigate("InformationAccountScreen") }
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.clickable { expanded = !expanded }
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_shield_check),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "Bagaimana mengubah kata sandi?",
                    fontFamily = localFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }
            Icon(
                modifier = Modifier.clickable { expanded = true },
                painter = if (expanded) painterResource(R.drawable.ic_arrow_back) else painterResource(
                    R.drawable.ic_arrow_up
                ),
                contentDescription = "Expand",
                tint = Color.Black
            )
        }
        if (expanded) {
            Row (
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Daftar",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily
                )
                Text(
                    text = "1. Pilih Peran (Role): Pihak Kafe atau Pencari Kerja",
                    fontSize = 12.sp,
                    fontFamily = localFontFamily
                )
                Text(
                    text = "2. Masukkan Email & Kata Sandi",
                    fontSize = 12.sp,
                    fontFamily = localFontFamily
                )
                Text(
                    text = "3. Klik Masuk ",
                    fontSize = 12.sp,
                    fontFamily = localFontFamily
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
//            .clickable { navController.navigate("InformationAccountScreen") }
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_user),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "Mengelola profil anda",
                    fontFamily = localFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = ""
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
//            .clickable { navController.navigate("InformationAccountScreen") }
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_information_circle),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "Masalah teknis dan bantuan ",
                    fontFamily = localFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = ""
            )
        }

    }
}