package com.example.internshipraionteam2.presentation.home.screen.profile

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.ViewModel.SharedViewModel
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Composable
fun ExperienceInformationScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel = viewModel()
) {
    var color1 = buttonfocus
    var email by rememberSaveable { mutableStateOf("") }
    val getData = sharedViewModel.state.value

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
            fontSize = 28.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W700)

        Spacer(modifier = Modifier.height(33.dp))

        Card(
            colors = CardDefaults.cardColors(buttonfocus),
            modifier = Modifier.fillMaxWidth()
                .height(120.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(start = 16.dp, end = 14.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Curriculum vitae",
                        fontSize = 16.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W500,
                        color = Color.White
                    )

                    Icon(
                        painter = painterResource(R.drawable.ic_pencil),
                        contentDescription = "",
                        tint = Color.White
                    )
                }

                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier.fillMaxWidth().height(52.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(R.drawable.pdf),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(17.dp))

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            "Agus Budianto_CV.pdf",
                            fontSize = 16.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.W400,
                            color = Color.Black
                        )
                    }
                }
            }
        }
                Spacer(modifier = Modifier.height(14.dp))
                Card(
                    colors = CardDefaults.cardColors(buttonfocus),
                    modifier = Modifier.fillMaxWidth()
                        .height(52.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize()
                            .padding(start = 18.dp, end = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Curriculum vitae",
                            fontSize = 16.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.W500,
                            color = Color.White)

                        Icon(painter = painterResource(R.drawable.ic_arrow_right),
                            contentDescription = "",
                            tint = Color.White
                        )

                    }
                }
    }
}