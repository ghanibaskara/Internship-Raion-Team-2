package com.example.internshipraionteam2.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.DataClass.AppliedTo
import com.example.internshipraionteam2.data.Firebase.DataClass.CafeDetails
import com.example.internshipraionteam2.data.Firebase.ViewModel.ApplicantsViewModel
import com.example.internshipraionteam2.presentation.home.elements.HistoryCard
import com.example.internshipraionteam2.ui.theme.localFontFamily

//@Preview
@Composable
fun FolderScreen(
    navController: NavController,
    applicantsViewModel: ApplicantsViewModel = viewModel()
) {
    val cafeDetailsList = remember { mutableStateListOf<CafeDetails>() }

    // Mengambil data aplikasi
    LaunchedEffect(Unit) {
        // Clear existing lists before fetching new data
        cafeDetailsList.clear()

        // First, get all application document IDs
        applicantsViewModel.getApplicationsDocumentsId { appliedTo ->
            // Iterate through each application document ID
            for (applicationDocId in appliedTo.timestamp) {
                // For each application document, get the cafe UID
                applicantsViewModel.getApplicationsId(applicationDocId) { appliedToCafes ->
                    // For each cafe UID, get the cafe details
                    for (cafeUid in appliedToCafes.id) {
                        // Fetch and add cafe details to the list
                        applicantsViewModel.getCafesData(cafeUid) { cafeDetails ->
                            cafeDetailsList.add(cafeDetails)
                        }
                    }
                }
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(start = 32.dp, end = 32.dp, top = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(modifier = Modifier.clickable {
                navController.navigate("BottomScreenApplicants")
            }, painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "Back",
                tint = Color.Black)
            Spacer(modifier = Modifier.width(30.dp))
            Text("Riwayat Lamaran",
                fontWeight = FontWeight.W700,
                fontFamily = localFontFamily,
                fontSize = 28.sp,
                color = Color.Black)
        }
        Spacer(modifier = Modifier.height(56.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(cafeDetailsList.size) { index ->
                val cafeDetails = cafeDetailsList[index]

                // Menampilkan kartu riwayat lamaran dengan nama cafe
                HistoryCard(
                    text = cafeDetails.name ?: "Cafe",
                    navController = navController
                )
            }
        }
    }
}