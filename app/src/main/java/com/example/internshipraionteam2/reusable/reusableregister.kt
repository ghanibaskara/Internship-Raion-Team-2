package com.example.internshipraionteam2.reusable

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.local.localFontFamily
import com.example.internshipraionteam2.reusable.signupbutton
import com.example.internshipraionteam2.presentation.registration.AuthViewModel
import com.example.internshipraionteam2.ui.theme.bordercolor
import com.example.internshipraionteam2.ui.theme.maincolor


//Text field for register
@Composable
fun RegisterTextField(name: String, onValueChange : (String) -> Unit, label: String, icons : ImageVector) {
    OutlinedTextField(
        name,
        onValueChange = onValueChange,
        label = { Text(label) },
        maxLines = 1,
        leadingIcon = {
            Icon(icons, contentDescription = "", tint = Color.Gray)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.padding(top = 16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            focusedBorderColor = Color.Gray,
            focusedTextColor = Color.Gray,
            unfocusedTextColor = Color.Gray
        )
    )


}



//Reusable "signup" button
@Composable
fun signupbutton(confirmpassword : String, password : String, email : String, authViewModel : AuthViewModel, navController: NavController,navigate : String) {
    val context = LocalContext.current
    Button(onClick = {
        if (confirmpassword != password){
            Toast.makeText(context, "Password tidak sama.", Toast.LENGTH_SHORT).show()
        } else if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(context, "Email atau password tidak boleh kosong.", Toast.LENGTH_SHORT).show()
        } else if(password.length <= 8){
            Toast.makeText(context, "Password harus lebih panjang dari 8 karakter.", Toast.LENGTH_SHORT).show()
        } else {
            authViewModel.signup(email, password)
            Toast.makeText(context, "Pembuatan Akun berhasil.", Toast.LENGTH_SHORT).show()
            navController.navigate(navigate)
        }
    }) {
        Text("Buat Akun")
    }

}

//Reusable "login" button

@Composable
fun loginbutton(password : String, email : String, authViewModel : AuthViewModel, navController: NavController, navigate: String) {
    val context = LocalContext.current
    Button(onClick = {
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(context, "Email atau password tidak boleh kosong.", Toast.LENGTH_SHORT).show()
        } else {
            authViewModel.login(email, password)
            Toast.makeText(context, "Login berhasil.", Toast.LENGTH_SHORT).show()
            navController.navigate(navigate)
        }
    }) {
        Text("Masuk")
    }

}





