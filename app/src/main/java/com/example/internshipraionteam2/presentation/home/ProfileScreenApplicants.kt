package com.example.internshipraionteam2.presentation.home

import androidx.compose.foundation.Image
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.network.SharedViewModel
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily


@Composable
fun ProfileScreenApplicants(
    navController: NavController,
    sharedViewModel: SharedViewModel = viewModel()
) {
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
            navController.popBackStack()
        },painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = "")
        }

        Image(painter = painterResource(R.drawable.dummy),
            contentDescription = "",
            modifier = Modifier.size(width = 176.dp, height = 176.dp)
                .clip(shape = RoundedCornerShape(90.dp)))

        Spacer(modifier = Modifier.height(3.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            Text(getData.fname,
                fontSize = 28.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W600)

            Spacer(modifier = Modifier.width(5.dp))

            Text(getData.lname,
            fontSize = 28.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600)
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            navController.navigate("InformationAccountScreen")
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
            ) { Text("Informasi akun",
                fontFamily = localFontFamily)
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.height(36.dp))

        Button(onClick = {
            navController.navigate("EditProfileScreen")
        }, modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(buttonfocus),
            shape = RoundedCornerShape(30)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) { Text("Edit profil",
                fontFamily = localFontFamily)
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.height(36.dp))

        Button(onClick = {
            navController.navigate("ExperienceInformationScreen")
        }, modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(buttonfocus),
            shape = RoundedCornerShape(30)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) { Text("Informasi pengalaman",
                fontFamily = localFontFamily)
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.height(36.dp))

        Button(onClick = {
            navController.navigate("SecurityPrivacyScreen")
        }, modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(buttonfocus),
            shape = RoundedCornerShape(30)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) { Text("Keamanan dan privasi",
                fontFamily = localFontFamily)
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
            }
        }

        Spacer(modifier = Modifier.height(90.dp))

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Transparent)) {
            Text("Keluar",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                color = Color.Red)
        }
    }
}