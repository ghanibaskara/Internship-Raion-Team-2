package com.example.internshipraionteam2.presentation.registration.screen.applicants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.data.local.localFontFamily
import com.example.internshipraionteam2.presentation.registration.AuthViewModel
import com.example.internshipraionteam2.reusable.signupbutton
import com.example.internshipraionteam2.reusable.RegisterTextField


@Composable
fun SignupScreenApplicants(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,

        ) {
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var confirmpassword by remember { mutableStateOf("") }

        Text(
            "Selamat Datang!",
            fontSize = 32.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 22.dp)
        )
        Text(
            "Lowongan baru sudah menunggu!",
            fontSize = 14.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            modifier = Modifier.padding(start = 22.dp)
        )

//        ***README
//        parameter authviewmodelnya aku hapus tadi, biar bisa di preview, nanti kalo mau nyoba" tinggal tambahin lagi aja


//
//        Text(
//            "Applicants Signup Page", fontSize = 32.sp
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        RegisterTextField(
//            email, onValueChange = { email = it }, "Email", icons = Icons.Filled.AccountCircle
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        RegisterTextField(
//            password, onValueChange = { password = it }, "Password", icons = Icons.Filled.Lock
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        RegisterTextField(
//            confirmpassword,
//            onValueChange = { confirmpassword = it },
//            "Confirm Password",
//            icons = Icons.Filled.Lock
//        )
//
//        signupbutton(confirmpassword,password,email,authViewModel, navController, "LoginScreenApplicants")
//
//        TextButton(onClick = {navController.navigate("LoginScreenApplicants")}) {
//            Text("Already have an account? Login Here.")
//        }

    }
}

@Preview
@Composable
fun SignupScreenApplicantsPreview(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    SignupScreenApplicants(navController)
}