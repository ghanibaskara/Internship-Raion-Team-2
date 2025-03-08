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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.reusable.RegisterTextField
import com.example.internshipraionteam2.ui.theme.buttonfocus

@Composable
fun LoginScreenCafe(navController: NavController,authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var check by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 210.dp)
        ) {
            Text("Selamat Datang!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000)
            )
            Text("Lowongan baru sudah menunggu!",
                fontSize = 14.sp,
                color = Color(0xFF000000)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp,end = 32.dp)
        ) {
            Text(text = "Email",
                fontWeight = FontWeight.W700,
                fontSize = 16.sp)

            RegisterTextField(email, onValueChange = {email = it}, "Email", icons = Icons.Filled.AccountCircle)

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Kata sandi",
                fontWeight = FontWeight.W700,
                fontSize = 16.sp)

            RegisterTextField(password, onValueChange = {password = it}, "Kata sandi", icons = Icons.Filled.Lock)

        }

        Spacer(modifier = Modifier.height(6.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Checkbox(
                checked = check,
                onCheckedChange = {check = it},
                colors = CheckboxDefaults.colors(buttonfocus)
            )
            Text("Ingat saya",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.width(130.dp))

            Text("Lupa kata sandi?",
                fontSize = 14.sp)
        }

        Button(onClick = {authViewModel.login(email, password)
            navController.navigate("RegisterScreenApplicants")},
            modifier = Modifier.fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            colors = ButtonDefaults.buttonColors(buttonfocus)) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("atau",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF9E9E9E)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {},
            modifier = Modifier.size(width = 346.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            border = BorderStroke(3.dp, Color.Gray)
        ) {
//            Image(painter = painterResource(R.drawable.))
            Text("Daftar dengan Google",
                fontSize = 14.sp,
                color = Color(0xFF000000),
                fontWeight = FontWeight.SemiBold)
        }

        TextButton(onClick = {navController.navigate("SignupScreenApplicants")}) {
            Text("Belum memiliki akun? ",
                color = Color(0xFF000000)
            )
            Text("Daftar sekarang",
                color = Color(0xFF000000),
                fontWeight = FontWeight.Bold
            )
        }
    }
}