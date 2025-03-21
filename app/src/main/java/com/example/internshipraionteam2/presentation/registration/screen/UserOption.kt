package com.example.internshipraionteam2.presentation.registration.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.ViewModel.AuthState
import com.example.internshipraionteam2.data.Firebase.ViewModel.AuthViewModel
import com.example.internshipraionteam2.data.Firebase.ViewModel.ApplicantsViewModel
import com.example.internshipraionteam2.data.Firebase.ViewModel.SharedViewModel
import com.example.internshipraionteam2.ui.theme.localFontFamily
import com.example.internshipraionteam2.ui.theme.bordercolor
import com.example.internshipraionteam2.ui.theme.maincolor


@Composable
fun UserOption(navController: NavController, authViewModel: AuthViewModel, sharedViewModel: SharedViewModel, applicantsViewModel: ApplicantsViewModel = viewModel()) {

    var stroke1 by remember { mutableStateOf(1.dp) }
    var border1 by remember { mutableStateOf(bordercolor) }
    var font1 by remember { mutableStateOf(FontWeight.Normal) }
    var stroke2 by remember { mutableStateOf(1.dp) }
    var border2 by remember { mutableStateOf(bordercolor) }
    var font2 by remember { mutableStateOf(FontWeight.Normal) }
    var isSelected1 by remember { mutableStateOf(false) }
    var isSelected2 by remember { mutableStateOf(false) }


    var color by remember { mutableStateOf(Color(0xFFEDEDED)) }
    var font by remember { mutableStateOf(FontWeight.Normal) }
    var fontcolor by remember { mutableStateOf(Color(0xFF9E9E9E)) }
    var fontcolor2 by remember { mutableStateOf(Color.Gray) }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        if (authState.value == AuthState.Authenticated){
            while (sharedViewModel.accountType.isEmpty());
            if (sharedViewModel.accountType == "applicants"){
                Toast.makeText(
                    context,
                    "User Authenticated. \n\t\t\tLogging in...",
                    Toast.LENGTH_SHORT
                ).show()

                while (applicantsViewModel.applicantData.biodataisfilled == null);
                if (applicantsViewModel.applicantData.biodataisfilled == true){
                    navController.navigate("BottomScreenApplicants")
                } else {
                    navController.navigate("GreetingScreenApplicants")
                }
            } else {

            }


        }
    }





//        if (sharedViewModel.currentUid.isNotEmpty()){
//            Toast.makeText(
//                context,
//               sharedViewModel.currentUid,
//                Toast.LENGTH_SHORT
//            ).show()
//            if (authState.value == AuthState.Authenticated){
//                if (sharedViewModel.accountType == "applicants"){
//                    if (sharedViewModel.biodataIsFilled == true){
//                        navController.navigate("HomeScreenApplicants")
//                    } else {
//                        navController.navigate("GreetingScreenApplicants")
//                    }
//                } else {
//                        navController.navigate("HomeScreenCafe")
//                }
//            }
//        }


//        when (authState.value) {
//            is AuthState.Authenticated -> navController.navigate("GreetingScreenApplicants")
//            is AuthState.Error -> Toast.makeText(
//                context,
//                (authState.value as AuthState.Error).message,
//                Toast.LENGTH_SHORT
//            ).show()
//
//            else -> Unit
//        }



if (isSelected1 || isSelected2){
        color = maincolor
        font = FontWeight.SemiBold
        fontcolor = Color.White
        fontcolor2 = Color.Black
    }




    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Saya seorang...",
            fontSize = 42.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Box(
            modifier = Modifier
                .height(435.dp)
                .width(326.dp)
                .border(BorderStroke(2.dp, color = bordercolor), shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(138.dp)
                        .width(294.dp)
                        .clickable {
                            isSelected1 = true
                            isSelected2 = false
                            stroke1 = 3.dp
                            border1 = maincolor
                            font1 = FontWeight.Bold
                            stroke2 = 1.dp
                            border2 = bordercolor
                            font2 = FontWeight.Normal
                        }
                        .border(
                            BorderStroke(stroke1, border1),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.vector1),
                            "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(start = 32.dp,end = 22.dp)
                        )
                        Text(
                            "Pencari Kerja",
                            fontSize = 20.sp,
                            fontFamily = localFontFamily,
                            fontWeight = font1,
                            color = maincolor
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .height(138.dp)
                        .width(294.dp)
                        .clickable {
                            isSelected2 = true
                            isSelected1 = false
                            stroke2 = 3.dp
                            border2 = maincolor
                            font2 = FontWeight.Bold
                            stroke1 = 1.dp
                            border1 = bordercolor
                            font1 = FontWeight.Normal
                        }
                        .border(
                            BorderStroke(stroke2, border2),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.vector2),
                            "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(start = 16.dp,end = 22.dp)
                        )
                        Text(
                            "Perekrut",
                            fontSize = 20.sp,
                            fontFamily = localFontFamily,
                            fontWeight = font2,
                            color = maincolor
                        )
                    }
                }
                Button(
                    onClick = {
                        if (isSelected1){
                            navController.navigate("SignupScreenApplicants")
                        } else if (isSelected2){
                            navController.navigate("SignupScreenCafe")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(color),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(41.dp)
                        .width(294.dp)
                ) {
                    Text(
                        "Buat Akun",
                        fontSize = 14.sp,
                        fontFamily = localFontFamily,
                        fontWeight = font,
                        color = fontcolor
                    )
                }
                TextButton(onClick = {
                    if (isSelected1){
                        navController.navigate("LoginScreenApplicants")
                    } else if (isSelected2){
                        navController.navigate("LoginScreenCafe")
                    }
                }) {
                    Text(
                        "Sudah memiliki akun?",
                        fontSize = 12.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = fontcolor2
                    )
                    Text(
                        " Masuk",
                        fontSize = 12.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = fontcolor2
                    )
                }

            }
        }
    }
}



