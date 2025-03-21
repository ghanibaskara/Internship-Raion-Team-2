package com.example.internshipraionteam2.presentation.home.screen.profile

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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import com.example.internshipraionteam2.ui.theme.colortext
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

        Spacer(modifier = Modifier.height(20.dp))

        Text("Pengaturan akun",
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 20.sp,
            color = colortext
        )

        Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .clickable { navController.navigate("InformationAccountScreen") },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {

                Icon(painter = painterResource(R.drawable.ic_user),
                    contentDescription = "")
                Spacer(modifier = Modifier.width(4.dp))
                Text("Informasi akun",
                fontFamily = localFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500)
                }
                Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
            }


        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable { navController.navigate("EditProfileScreen") },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
            Icon(painter = painterResource(R.drawable.ic_pencil_alt),
                contentDescription = "")
            Spacer(modifier = Modifier.width(4.dp))
            Text("Edit profil",
                fontFamily = localFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500)
            }
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable { navController.navigate("ExperienceInformationScreen") },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
            Icon(painter = painterResource(R.drawable.ic_briefcase),
                contentDescription = "", tint = Color.Black)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Informasi pengalaman",
                fontFamily = localFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500)
            }
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable { navController.navigate("ExperienceInformationScreen") },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
            Icon(painter = painterResource(R.drawable.ic_shield_check),
                contentDescription = "")
            Spacer(modifier = Modifier.width(4.dp))
            Text("Kemanan dan privasi",
                fontFamily = localFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500)
            }
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
        }

        Spacer(modifier = Modifier.height(27.dp))

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start){
        Text("Lainnya",
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 20.sp,
            color = colortext
        )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable { navController.navigate("AboutUsScreen") },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
            Icon(painter = painterResource(R.drawable.ic_user_group),
                contentDescription = "")
            Spacer(modifier = Modifier.width(4.dp))
            Text("Tentang kami",
                fontFamily = localFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500)
            }
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable { navController.navigate("HelperScreen") },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
            Icon(painter = painterResource(R.drawable.ic_information_circle),
                contentDescription = "")
            Spacer(modifier = Modifier.width(4.dp))
            Text("Pusat layanan",
                fontFamily = localFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500)
            }
            Icon(painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "")
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable { navController.navigate("") },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Keluar",
                fontFamily = localFontFamily,
                fontSize = 16.sp,
                color = Color.Red,
                fontWeight = FontWeight.W600)
        }
    }
}