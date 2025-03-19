package com.example.internshipraionteam2.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Composable
fun WorkDetail(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(start = 32.dp, end = 32.dp, top = 64.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "",
                modifier = Modifier.clickable {
                    navController.navigate("BottomScreenApplicants")
                }
                )

            Spacer(modifier = Modifier.width(48.dp))

            Text("Daftar Lowongan",
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                fontFamily = localFontFamily
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.height(50.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                    modifier = Modifier.size(50.dp),
                    tint = Color.Unspecified)
                Image(painter = painterResource(R.drawable.laluna_caffee), contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(30.dp)))
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Waiter",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W700)

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text("Laluna Space",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W400)

                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(painter = painterResource(R.drawable.ellipse_46),
                        contentDescription = "",
                        tint = Color.Black)
                    Spacer(modifier = Modifier.width(8.dp))

                    Text("Lowokwaru, Malang",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W400)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row() {
            Icon(painter = painterResource(R.drawable.tag_fulltime), contentDescription = "",
                tint = buttonfocus)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(buttonfocus),
            modifier = Modifier.fillMaxWidth().
            height(34.dp)){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start) {
                Text("Deskripsi pekerjaan",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W600)

                Spacer(modifier = Modifier.width(60.dp))

                Text("Deskripsi kafe",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W600)
            }

        }
            Spacer(modifier = Modifier.height(24.dp))

            Text("Deskripsi posisi",
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W600)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Bertanggung jawab untuk melayani pelanggan dengan ramah, mencatat pesanan dengan akurat, membantu menjaga kebersihan area makan dan berkoordinasi dengan tim dapur untuk menyajikan makanan tepat waktu.",
            color = Color.Black,
            fontSize = 12.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W400)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Kualifikasi",
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600)

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                tint = buttonfocus, modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Memiliki pengalaman selama 1 tahun sebagai waiter.",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 11.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                tint = buttonfocus, modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Berpenampilan menarik.",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 11.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                tint = buttonfocus, modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Mampu bekerja dalam tim dengan cepat dan efisien.",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 11.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                tint = buttonfocus, modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Bersedia bekerja dalam shift, akhir pekan dan hari libur.",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 11.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Benefit",
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600)

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                tint = buttonfocus, modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Gaji Rp3.000.000/bulan + uang service & tip",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 11.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                tint = buttonfocus, modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Diskon karyawan untuk semua menu di kafe.",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 11.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                tint = buttonfocus, modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Lingkungan kerja yang nyaman.",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 11.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                tint = buttonfocus, modifier = Modifier.size(10.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Peluang pengembangan karier.",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 11.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Durasi lowongan dibuka",
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600)

        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(painter = painterResource(R.drawable.ic_calendar),
                contentDescription = "",
                tint = Color.Black)
            Spacer(modifier = Modifier.width(6.dp))

            Text("3 Maret - 30 Maret 2025",
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black)

            }

        Spacer(modifier = Modifier.height(29.dp))

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(buttonfocus),
            modifier = Modifier.fillMaxWidth()){
            Text("Ajukan Lamaran",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W600)
        }
    }
}