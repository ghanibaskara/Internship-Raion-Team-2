package com.example.internshipraionteam2.presentation.registration

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.reusable.PasswordTextField
import com.example.internshipraionteam2.reusable.RegisterTextField
import com.example.internshipraionteam2.reusable.buttonfocus

@Composable
fun SignupScreenCafe(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var confirmpassword by remember { mutableStateOf("") }
        var check by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 151.dp),
        ) {
            Text(
                "Halo !",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000),
                textAlign = TextAlign.Start
            )
            Text(
                "Kerja di kafe jadi lebih mudah, daftar sekarang!",
                fontSize = 14.sp,
                color = Color(0xFF000000),
                textAlign = TextAlign.Start
            )

        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)

        ) {
            Text(text = "Email",
                fontWeight = FontWeight.W700,
                fontSize = 16.sp)

            RegisterTextField(email, onValueChange = {email = it}, "Email", icons = Icons.Filled.AccountCircle)

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Kata sandi",
                fontWeight = FontWeight.W700,
                fontSize = 16.sp)

            PasswordTextField(password, onValueChange = {password = it}, "Kata sandi", icons = Icons.Filled.Lock, visualTransformation = PasswordVisualTransformation())

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Konfirmasi kata sandi",
                fontWeight = FontWeight.W700,
                fontSize = 16.sp)

            PasswordTextField(confirmpassword, onValueChange = {confirmpassword = it}, "Konfirmasi kata sandi", icons = Icons.Filled.Lock, visualTransformation = PasswordVisualTransformation())
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = check,
                onCheckedChange = {check = it},
                colors = CheckboxDefaults.colors(com.example.internshipraionteam2.ui.theme.buttonfocus)
            )
            Text("I agree with the ",
                fontSize = 12.sp)

            Text("terms of service ",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold)
            Text("and ",
                fontSize = 12.sp)
            Text("privacy policy",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold)
        }

        Button(onClick = { navController.navigate("LoginScreenCafe") },
            modifier = Modifier.size(width = 346.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonfocus)
        ) {
            Text("Daftar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {},
            modifier = Modifier.size(width = 346.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            border = BorderStroke(3.dp, Color.Gray)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "google icon")
            Text("Daftar dengan Google",
                fontSize = 14.sp,
                color = Color(0xFF000000),
                fontWeight = FontWeight.SemiBold)
        }

        TextButton(onClick = {}) {
            Text("Sudah memiliki akun? ",
                color = Color(0xFF000000)
            )
            Text("Masuk",
                color = Color(0xFF000000),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

