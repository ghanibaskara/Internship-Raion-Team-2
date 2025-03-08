package com.example.internshipraionteam2.presentation.registration.screen.applicants

import android.graphics.drawable.PaintDrawable
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.presentation.registration.AuthViewModel
import com.example.internshipraionteam2.reusable.signupbutton
import com.example.internshipraionteam2.reusable.RegisterTextField
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily


@Composable
fun SignupScreenApplicants(navController: NavController,authViewModel: AuthViewModel) {
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
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000),
                textAlign = TextAlign.Start
            )
            Text(
                "Kerja di kafe jadi lebih mudah, daftar sekarang!",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
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
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp)

            RegisterTextField(email, onValueChange = {email = it}, "Email", icons = Icons.Filled.AccountCircle)

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Kata sandi",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp)

            RegisterTextField(password, onValueChange = {password = it}, "Kata sandi", icons = Icons.Filled.Lock)

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Konfirmasi kata sandi",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp)

            RegisterTextField(confirmpassword, onValueChange = {confirmpassword = it}, "Konfirmasi kata sandi", icons = Icons.Filled.Lock)
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = check,
                onCheckedChange = {check = it},
                colors = CheckboxDefaults.colors(buttonfocus)
            )
            Text("I agree with the ",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp)

            Text("terms of service ",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold,)
            Text("and ",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp)
            Text("privacy policy",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold)
        }

        Button(onClick = { navController.navigate("LoginScreenApplicants") },
            modifier = Modifier.size(width = 346.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonfocus)
        ) {
            Text("Daftar",fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("atau",
            fontSize = 12.sp,
            fontFamily = localFontFamily,
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
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold)
        }

        TextButton(onClick = {}) {
            Text("Sudah memiliki akun? ",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF000000)
            )
            Text("Masuk",
                color = Color(0xFF000000),
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }
}