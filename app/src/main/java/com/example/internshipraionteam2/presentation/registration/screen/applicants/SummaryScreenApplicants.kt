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


        var expandedIndex by remember { mutableStateOf(-1) }

        val items = listOf(
            "Biodata" to listOf(
                "Nama depan      : Agus",
                "Nama belakang   : Budianto",
                "Tanggal lahir   : 17 Desember 1998",
                "Nomor telepon   : 087156509887",
                "Lokasi tinggal  : Lowokwaru, Malang"
            ),
            "Curriculum Vitae" to listOf(
                "Agus Budianto_CV.pdf"
            ),
            "Sertifikasi" to listOf(
                "Anda belum mengungah berkas sertifikasi.",
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