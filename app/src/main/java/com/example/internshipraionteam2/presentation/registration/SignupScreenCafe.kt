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
fun SignupScreenCafe(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var confirmpassword by remember { mutableStateOf("") }

        Text(
            "Cafe Signup Page",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        RegisterTextField(email, onValueChange = {email = it}, "Email", icons = Icons.Filled.AccountCircle)

        Spacer(modifier = Modifier.height(16.dp))

        RegisterTextField(password, onValueChange = {password = it}, "Password", icons = Icons.Filled.Lock)

        Spacer(modifier = Modifier.height(16.dp))

        RegisterTextField(confirmpassword, onValueChange = {confirmpassword = it}, "Confirm Password", icons = Icons.Filled.Lock)

        Button(onClick = { navController.navigate("LoginScreenCafe") }) {
            Text("SignUp")
        }

        TextButton(onClick = {}) {
            Text("Already have an account? Login Here.")
        }

    }
}