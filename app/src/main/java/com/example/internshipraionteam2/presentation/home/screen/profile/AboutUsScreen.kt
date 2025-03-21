package com.example.internshipraionteam2.presentation.home.screen.profile

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
fun AboutUsScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {

        Spacer(modifier = Modifier.height(94.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            Icon(painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.clickable {
                    navController.navigate("BottomScreenApplicants")
                })
        }

        Spacer(modifier = Modifier.height(23.dp))

        Text("Tentang kami",
            fontSize = 28.sp,
            fontWeight = FontWeight.W700,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(23.dp))

        Icon(painter = painterResource(R.drawable.koper),
            contentDescription = "",
            tint = Color.Unspecified)

        Spacer(modifier = Modifier.height(28.dp))

        Text("CafeCrew",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("adalah platform yang menghubungkan pencari kerja dengan berbagai kafe yang sedang membuka lowongan. Kami hadir untuk mempermudah proses pencarian kerja bagi para pekerja kafe dan pemilik usaha.",
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Visi kami",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("Menjadi platform terbaik dan terpercaya dalam menghubungkan pencari kerja dengan kafe impian mereka, serta membantu pemilik kafe menemukan pekerja yang tepat dengan mudah dan cepat.",
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Misi kami",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("1. Mempermudah pencarian kerja",
            fontSize = 12.sp,
            fontWeight = FontWeight.W600,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("Menyediakan platform yang praktis dan efisien bagi pencari kerja untuk menemukan lowongan di kafe dengan cepat.",
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("2. Mendukung Pemilik Kafe",
            fontSize = 12.sp,
            fontWeight = FontWeight.W600,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("Menyediakan platform yang praktis dan efisien bagi pencari kerja untuk menemukan lowongan di kafe dengan cepat.",
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("3. Meningkatkan Aksesibilitas",
            fontSize = 12.sp,
            fontWeight = FontWeight.W600,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("Memberikan sistem yang mudah digunakan bagi semua pengguna, baik pencari kerja maupun pemilik kafe.",
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(48.dp))

        Text("Sosial Media",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            fontFamily = localFontFamily,
            color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(R.drawable.tiktok),
                    contentDescription = "",
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(4.dp))

                Text("@cafecrew",
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily,
                    fontSize = 12.sp,
                    color = Color.Black)
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(R.drawable.ic_instagram),
                    contentDescription = "",
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(4.dp))

                Text("@cafecrew",
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily,
                    fontSize = 12.sp,
                    color = Color.Black)
            }
        }
    }
}
