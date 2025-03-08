package com.example.internshipraionteam2.presentation.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.reusable.RegisterTextField


@Composable
fun LoginScreenApplicants(navController: NavController, authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        Text("Applicants Login Page",
            fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))

        RegisterTextField(email, onValueChange = {email = it}, "Email", icons = Icons.Filled.AccountCircle)

        Spacer(modifier = Modifier.height(16.dp))

        RegisterTextField(password, onValueChange = {password = it}, "Password", icons = Icons.Filled.Lock)

        Button(onClick = {authViewModel.login(email, password)
        navController.navigate("RegisterScreenApplicants")}) {
            Text("Login")
        }

        TextButton(onClick = {navController.navigate("SignupScreenApplicants")}) {
            Text("Dont have an account? Signup Here.")
        }

    }
}