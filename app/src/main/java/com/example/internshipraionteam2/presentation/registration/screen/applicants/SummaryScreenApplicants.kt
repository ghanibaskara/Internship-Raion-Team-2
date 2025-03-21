package com.example.internshipraionteam2.presentation.registration.screen.applicants

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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.ViewModel.SharedViewModel
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore


@Composable
fun SummaryScreenApplicants(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val auth = FirebaseAuth.getInstance().currentUser
    val uid = auth?.uid ?: ""
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(top = 94.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        var expanded by remember { mutableStateOf(false) }

        Row(modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            Icon(modifier = Modifier.clickable {
                navController.popBackStack()
            },painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "arrow back")
            Spacer(modifier = Modifier.width(80.dp))
            Text("Unggah berkas",
                fontSize = 20.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
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
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold,
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
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold,
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
                Text(text = "3",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Rangkuman Berkas",
            fontSize = 24.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header Dropdown
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                colors = CardDefaults.cardColors(containerColor = Color(0xFF333333)) // Warna abu-abu gelap
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Biodata",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        painter = if (expanded) painterResource(R.drawable.ic_arrow_back) else painterResource(R.drawable.ic_arrow_up),
                        contentDescription = "Expand",
                        tint = Color.White
                    )
                }
            }

            // Isi Dropdown (Hanya muncul jika expanded = true)
            if (expanded) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Biodata",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        BiodataRow(label = "Nama depan", value = "Agus")
                        BiodataRow(label = "Nama belakang", value = "Budianto")
                        BiodataRow(label = "Tanggal lahir", value = "17 Desember 1998")
                        BiodataRow(label = "Nomor telepon", value = "087156509887")
                        BiodataRow(label = "Lokasi tinggal", value = "Lowokwaru, Malang")
                    }
                }
            }
        }

////////////////////////////////////////////////////
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 32.dp, end = 32.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text("Biodata",
//                fontFamily = localFontFamily,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 16.sp)
//            Icon(painterResource(R.drawable.ic_arrow_down),
//                contentDescription = "")
//        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header Dropdown
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                colors = CardDefaults.cardColors(containerColor = Color(0xFF333333)) // Warna abu-abu gelap
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "CV",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        painter = if (expanded) painterResource(R.drawable.ic_arrow_back) else painterResource(R.drawable.ic_arrow_up),
                        contentDescription = "Expand",
                        tint = Color.White
                    )
                }
            }

            // Isi Dropdown (Hanya muncul jika expanded = true)
            if (expanded) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "CV",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        BiodataRow(label = "CV", value = "")
                    }
                }
            }
        }

        //////////////////////////////////////////
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 32.dp, end = 32.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text("Curriculum Vitae",
//                fontFamily = localFontFamily,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 16.sp)
//            Icon(painterResource(R.drawable.ic_arrow_down),
//                contentDescription = "")
//        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header Dropdown
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                colors = CardDefaults.cardColors(containerColor = Color(0xFF333333)) // Warna abu-abu gelap
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Sertifikat",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        painter = if (expanded) painterResource(R.drawable.ic_arrow_back) else painterResource(R.drawable.ic_arrow_up),
                        contentDescription = "Expand",
                        tint = Color.White
                    )
                }
            }

            // Isi Dropdown (Hanya muncul jika expanded = true)
            if (expanded) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Sertifikat",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        BiodataRow(label = "Sertifikat", value = "")
                    }
                }
            }
        }

        ////////////////////////////////////
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 32.dp, end = 32.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text("Sertifikasi",
//                fontFamily = localFontFamily,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 16.sp)
//            Icon(painterResource(R.drawable.ic_arrow_down),
//                contentDescription = "")
//        }

        Spacer(modifier = Modifier.height(333.dp))

        Button(onClick = {
            val documentRef = Firebase.firestore.collection("biodata").document(uid)
            documentRef.update("biodataisfilled", true)
            navController.navigate("BottomScreenApplicants")
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .size(width = 0.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonfocus)
        ) {
            Text("Selanjutnya",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ExpandableBiodataCard() {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header Dropdown
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            colors = CardDefaults.cardColors(containerColor = Color(0xFF333333)) // Warna abu-abu gelap
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Biodata",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    painter = if (expanded) painterResource(R.drawable.ic_arrow_back) else painterResource(R.drawable.ic_arrow_up),
                    contentDescription = "Expand",
                    tint = Color.White
                )
            }
        }

        // Isi Dropdown (Hanya muncul jika expanded = true)
        if (expanded) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Biodata",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    BiodataRow(label = "Nama depan", value = "Agus")
                    BiodataRow(label = "Nama belakang", value = "Budianto")
                    BiodataRow(label = "Tanggal lahir", value = "17 Desember 1998")
                    BiodataRow(label = "Nomor telepon", value = "087156509887")
                    BiodataRow(label = "Lokasi tinggal", value = "Lowokwaru, Malang")
                }
            }
        }
    }
}

// Reusable Row untuk Biodata
@Composable
fun BiodataRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label :",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
    }
}