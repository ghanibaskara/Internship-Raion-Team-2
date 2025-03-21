package com.example.internshipraionteam2.presentation.registration.screen.cafe

import android.widget.Toast
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.ViewModel.AuthViewModel
import com.example.internshipraionteam2.data.Firebase.ViewModel.SharedViewModel
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily
import com.example.internshipraionteam2.ui.theme.maincolor


@Composable
fun SignupScreenCafe(
    navController: NavController,
    authViewModel: AuthViewModel,
    sharedViewModel: SharedViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var confirmpassword by remember { mutableStateOf("") }
        var check by remember { mutableStateOf(false) }
        val context = LocalContext.current
        var isPasswordVisible by remember { mutableStateOf(false) }


        var color1 by remember { mutableStateOf(Color.Gray) }
        if (email == "") color1 = Color.Gray else color1 = maincolor

        var color2 by remember { mutableStateOf(Color.Gray) }
        if (password == "") color2 = Color.Gray else color2 = maincolor

        var color3 by remember { mutableStateOf(Color.Gray) }
        if (confirmpassword == "") color3 = Color.Gray else color3 = maincolor


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 151.dp),
        ) {
            Text(
                "Cafe !",
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
            Text(
                text = "Email",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            OutlinedTextField(
                email,
                onValueChange = { email = it },
                singleLine = true,
                placeholder = {
                    Text(
                        "Masukkan email Anda",
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                },
                leadingIcon = {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "", tint = color1)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLabelColor = color1,
                    focusedLabelColor = color1,
                    unfocusedBorderColor = color1,
                    focusedBorderColor = color1,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Kata sandi",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            OutlinedTextField(
                password,
                onValueChange = { password = it },
                singleLine = true,
                placeholder = {
                    Text(
                        "Masukkan kata sandi Anda",
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                },
                leadingIcon = {
                    Icon(Icons.Filled.Lock, contentDescription = "", tint = color2)
                },
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            painter = if (isPasswordVisible) painterResource(R.drawable.baseline_visibility_24) else painterResource(
                                R.drawable.baseline_visibility_off_24
                            ), "", tint = color2
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                colors =
                OutlinedTextFieldDefaults.colors(
                    unfocusedLabelColor = color2,
                    focusedLabelColor = color2,
                    unfocusedBorderColor = color2,
                    focusedBorderColor = color2,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )




            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Konfirmasi kata sandi",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            OutlinedTextField(
                confirmpassword,
                onValueChange = { confirmpassword = it },
                singleLine = true,
                placeholder = {
                    Text(
                        "Konfirmasi ulang kata sandi Anda",
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                },
                leadingIcon = {
                    Icon(Icons.Filled.Lock, contentDescription = "", tint = color3)
                },
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            painter = if (isPasswordVisible) painterResource(R.drawable.baseline_visibility_24) else painterResource(
                                R.drawable.baseline_visibility_off_24
                            ), "", tint = color3
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLabelColor = color3,
                    focusedLabelColor = color3,
                    unfocusedBorderColor = color3,
                    focusedBorderColor = color3,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )
        }

        Row(
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = check,
                onCheckedChange = { check = it },
                colors = CheckboxDefaults.colors(buttonfocus)
            )
            Text(
                "I agree with the ",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )

            Text(
                "terms of service ",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold,
            )
            Text(
                "and ",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
            Text(
                "privacy policy",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {
                if (confirmpassword != password) {
                    Toast.makeText(context, "Password tidak sama.", Toast.LENGTH_SHORT).show()
                } else if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Email atau password tidak boleh kosong.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (password.length <= 8) {
                    Toast.makeText(
                        context,
                        "Password harus lebih panjang dari 8 karakter.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    authViewModel.signup(email, password, "cafe")
                    navController.navigate("LoginScreenCafe")

                }
            },
            modifier = Modifier.size(width = 346.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonfocus)
        ) {
            Text(
                "Daftar", fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "atau",
            fontSize = 12.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF9E9E9E)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {},
            modifier = Modifier.size(width = 346.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            border = BorderStroke(3.dp, Color.Gray)
        ) {
//            Image(painter = painterResource(R.drawable.))
            Text(
                "Daftar dengan Google",
                fontSize = 14.sp,
                color = Color(0xFF000000),
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }

        TextButton(onClick = { navController.navigate("LoginScreenCafe") }) {
            Text(
                "Sudah memiliki akun? ",
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF000000)
            )
            Text(
                "Masuk",
                color = Color(0xFF000000),
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }
}