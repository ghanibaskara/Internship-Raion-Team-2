package com.example.internshipraionteam2.presentation.home.screen

import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.DataClass.CafeDetails
import com.example.internshipraionteam2.data.Firebase.ViewModel.ApplicantsViewModel
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily
import kotlinx.coroutines.flow.callbackFlow

//@Preview
@Composable
fun WorkDetail(
    navController: NavController,
    cafeuid: String,
    applicantsViewModel: ApplicantsViewModel = viewModel()
) {
    // Use remember to maintain state across recompositions
    var cafeDetails by remember { mutableStateOf(CafeDetails()) }

    LaunchedEffect(cafeuid) {
        applicantsViewModel.getCafesData(cafeuid) { data ->
            cafeDetails = data
        }
    }

    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Deskripsi pekerjaan", "Deskripsi kafe")

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                contentDescription = "Back",
                modifier = Modifier.clickable {
                    navController.navigate("BottomScreenApplicants")
                }
            )

            Spacer(modifier = Modifier.width(48.dp))

            Text(
                "Daftar Lowongan",
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
                Icon(
                    painter = painterResource(R.drawable.ellipse_16),
                    contentDescription = "Cafe Image Background",
                    modifier = Modifier.size(50.dp),
                    tint = Color.Unspecified
                )
                Image(
                    painter = painterResource(R.drawable.laluna_caffee),
                    contentDescription = "Cafe Image",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    cafeDetails.job,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W700
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        cafeDetails.name,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W400
                    )

                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(R.drawable.ellipse_46),
                        contentDescription = "Dot",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        cafeDetails.location,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W400
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row() {
            Icon(
                painter = painterResource(R.drawable.tag_fulltime),
                contentDescription = "Full Time",
                tint = buttonfocus
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEDEDED), shape = RoundedCornerShape(50))
        ) {
            tabTitles.forEachIndexed { index, title ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(50))
                        .background(if (selectedTabIndex == index) Color(0xFF6F4A31) else Color.Transparent)
                        .clickable { selectedTabIndex = index }
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = title,
                        color = if (selectedTabIndex == index) Color.White else Color(0xFF6F4A31),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        when (selectedTabIndex) {
            0 -> DeskripsiPosisi(
                cafeDetails
            )
            1 -> DeskripsiKafe(cafeDetails)
        }
    }
}

@Composable
fun DeskripsiPosisi(
    cafeDetails: CafeDetails,
    applicantsViewModel: ApplicantsViewModel = viewModel()
) {
    var cafeDetails = cafeDetails
    var context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Deskripsi posisi",
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            cafeDetails.positiondescription,
            color = Color.Black,
            fontSize = 12.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W400
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Kualifikasi",
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600
        )

        Spacer(modifier = Modifier.height(12.dp))

        cafeDetails.qualifications.forEach { qualification ->
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ellipse_16),
                    contentDescription = "Bullet",
                    tint = buttonfocus,
                    modifier = Modifier.size(10.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    qualification,
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily,
                    fontSize = 11.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Benefit",
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600
        )

        Spacer(modifier = Modifier.height(12.dp))

       cafeDetails.benefit.forEach { ben ->
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ellipse_16),
                    contentDescription = "Bullet",
                    tint = buttonfocus,
                    modifier = Modifier.size(10.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    ben,
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily,
                    fontSize = 11.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Durasi lowongan dibuka",
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(R.drawable.ic_calendar),
                contentDescription = "Calendar",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(
                cafeDetails.applicationduration,
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(29.dp))

        Button(
            onClick = {
                if (applicantsViewModel.applicantData.biodataisfilled == false){
                    Toast.makeText(
                        context,
                        "Biodata kosong, tidak dapat mengirim data.",
                        Toast.LENGTH_SHORT
                    ).show()
                }else {
                applicantsViewModel.applicationFunction(cafeDetails.uid,cafeDetails.job,cafeDetails.name,cafeDetails.location)}
            },
            colors = ButtonDefaults.buttonColors(buttonfocus),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Ajukan Lamaran",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W600
            )
        }
    }
}

@Composable
fun DeskripsiKafe(cafeDetails: CafeDetails,
                  applicantsViewModel: ApplicantsViewModel = viewModel()
) {
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Deskripsi Kafe",
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            cafeDetails.cafedescription,
            color = Color.Black,
            fontSize = 12.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W400
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = "Location",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(
                cafeDetails.extendedlocation,
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(13.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_clock),
                contentDescription = "Work Hours",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(
                cafeDetails.worktime,
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(13.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_call),
                contentDescription = "Phone",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(
                cafeDetails.phone,
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(13.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = "Rating",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(
                cafeDetails.rating,
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                if (applicantsViewModel.applicantData.biodataisfilled == false){
                    Toast.makeText(
                        context,
                        "Biodata kosong, tidak dapat mengirim data.",
                        Toast.LENGTH_SHORT
                    ).show()
                }else {
                    applicantsViewModel.applicationFunction(cafeDetails.uid,cafeDetails.job,cafeDetails.name,cafeDetails.location)}
            },
            colors = ButtonDefaults.buttonColors(buttonfocus),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Text(
                "Ajukan Lamaran",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W600
            )
        }
    }
}