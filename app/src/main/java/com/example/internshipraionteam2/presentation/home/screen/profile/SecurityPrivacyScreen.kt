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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun SecurityPrivacyScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(start = 32.dp, end = 32.dp, top = 94.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(modifier = Modifier.clickable {
            navController.navigate("ProfileScreenApplicants")
            },painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "")
        }

        Spacer(modifier = Modifier.height(43.dp))

        Text("Keamanan dan privasi",
            fontSize = 24.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600)

        Spacer(modifier = Modifier.height(142.dp))

        Button(onClick = {

        }, modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(buttonfocus),
            shape = RoundedCornerShape(30)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) { Text("Ubah kata sandi",
                fontFamily = localFontFamily)
                Icon(painter = painterResource(R.drawable.ic_arrow_right),
                    contentDescription = "")
            }

        }
        Spacer(modifier = Modifier.height(36.dp))

        Button(onClick = {

        }, modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(buttonfocus),
            shape = RoundedCornerShape(30)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) { Text("Hapus/non-aktifkan akun",
                fontFamily = localFontFamily)
                Icon(painter = painterResource(R.drawable.ic_arrow_right),
                    contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.height(187.dp))

        Button(onClick = {},
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(buttonfocus)) {
            Text("Simpan",
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily
            )
        }
    }
}