package com.example.internshipraionteam2.presentation.home

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.presentation.registration.screen.applicants.BiodataRow
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Composable
fun HelpCenter(
    navController: NavController
) {

    var expandedIndex by remember { mutableStateOf(-1) } // Menyimpan indeks dropdown yang terbuka

    val items = listOf(
        "Bagaimana daftar/masuk akun?" to listOf(
            "1. Pilih Peran (Role): Pihak Kafe atau Pencari Kerja",
            "2. Masukkan Data Pendaftaran: Email, kata sandi, konfirmasi kata sandi, nama lengkap (pencari kerja) atau nama kafe (employer)",
            "3. Masukkan file yang diperlukan",
            "4. Jika sudah memiliki akun, pilih Masuk dan masukkan email serta kata sandi Anda.",
            "5. Masukkan Data Pendaftaran: Email, kata sandi, konfirmasi kata sandi, nama lengkap (pencari kerja) atau nama kafe (employer)",
            "6. Masukkan file yang diperlukan"
        ),
        "Bagaimana mengubah kata sandi?" to listOf(
            "1. Masuk ke menu Pengaturan",
            "2. Pilih 'Ubah Kata Sandi'",
            "3. Masukkan kata sandi lama dan baru",
            "4. Masukkan kata sandi lama, lalu buat kata sandi baru.",
            "5. Konfirmasi kata sandi baru dan tekan Simpan."
        ),
        "Mengelola profil anda" to listOf(
            "1. Perbarui informasi pribadi, pengalaman, dan kata ",
            "2. sandi di bagian profil.",
            "3. Unggah foto profil profesional."
        ),
        "Masalah teknis dan bantuan" to listOf(
            "1. Jika mengalami kendala teknis, coba tutup dan buka kembali aplikasi.",
            "2. Hubungi tim dukungan melalui email crewcafe@gmail.com"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
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

        items.forEachIndexed { index, (title, details) ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        expandedIndex = if (expandedIndex == index) -1 else index
                    }
                    .padding(vertical = 8.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_user),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = title,
                            fontFamily = localFontFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500
                        )
                    }

                    Icon(
                        painter = if (expandedIndex == index)
                            painterResource(R.drawable.ic_arrow_up)
                        else
                            painterResource(R.drawable.ic_arrow_down),
                        contentDescription = "Expand",
                        tint = Color.Black
                    )
                }


                if (expandedIndex == index && details != null) {
                    Column(
                        modifier = Modifier.padding(start = 32.dp, top = 8.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        details.forEach { detail ->
                            Text(
                                text = detail,
                                fontSize = 14.sp,
                                fontFamily = localFontFamily
                            )
                        }
                    }
                }
            }
            Divider(color = Color.Gray.copy(alpha = 0.3f))
        }
    }
}