package com.example.internshipraionteam2.presentation.registration.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.local.localFontFamily
import com.example.internshipraionteam2.reusable.useroptionbutton
import com.example.internshipraionteam2.ui.theme.bordercolor
import com.example.internshipraionteam2.ui.theme.maincolor


@Composable
fun UserOption(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Saya seorang...",
            fontSize = 42.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Box(
            modifier = Modifier
                .height(435.dp)
                .width(326.dp)
                .border(BorderStroke(2.dp, color = bordercolor), shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                useroptionbutton(painterResource(R.drawable.vector1), "Pencari Kerja", 32)
                Spacer(modifier = Modifier.height(24.dp))
                useroptionbutton(painterResource(R.drawable.vector2), "Perekrut", 16)
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(maincolor),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(41.dp)
                        .width(294.dp)
                ) { Text("Buat Akun", fontSize = 14.sp, fontFamily = localFontFamily, fontWeight = FontWeight.SemiBold, color = Color.White) }
                TextButton(onClick = {}) {
                    Text("Sudah memiliki akun?",fontSize = 12.sp, fontFamily = localFontFamily, fontWeight = FontWeight.Normal, color = Color.Black)
                    Text(" Masuk",fontSize = 12.sp, fontFamily = localFontFamily, fontWeight = FontWeight.Bold, color = Color.Black)
                }

            }
        }
    }
}

@Preview
@Composable
fun UserOptionPreview(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    UserOption(navController)
}

