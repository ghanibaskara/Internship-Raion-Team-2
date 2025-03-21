package com.example.internshipraionteam2.presentation.registration.elements

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.data.Firebase.ViewModel.AuthViewModel
import com.example.internshipraionteam2.ui.theme.localFontFamily
import com.example.internshipraionteam2.ui.theme.maincolor


//Text field for register
@Composable
fun RegisterTextField(name: String, onValueChange : (String) -> Unit, label: String, icons : ImageVector) {
    var color by remember { mutableStateOf(Color.Gray) }
    if (name == "") color = Color.Gray else color = maincolor
    OutlinedTextField(
        name,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {
            Text(label, fontFamily = localFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
        },
        leadingIcon = {
            Icon(icons, contentDescription = "", tint = color)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.padding(top = 4.dp)
            .fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = color,
            focusedLabelColor = color,
            unfocusedBorderColor = color,
            focusedBorderColor = color,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        )
    )
}
@Composable
fun PasswordTextField(name: String, onValueChange : (String) -> Unit, label: String, icons : ImageVector,visualTransformation: PasswordVisualTransformation) {
    OutlinedTextField(
        name,
        onValueChange = onValueChange,
        label = { Text(label) },
        maxLines = 1,
        leadingIcon = {
            Icon(icons, contentDescription = "", tint = Color.Gray)
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.padding(top = 4.dp)
            .fillMaxWidth(),
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
fun signupbutton(confirmpassword : String, password : String, email : String, authViewModel : AuthViewModel, navController: NavController) {
    val context = LocalContext.current
    Button(onClick = {
        if (confirmpassword != password){
            Toast.makeText(context, "Password tidak sama.", Toast.LENGTH_SHORT).show()
        } else if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(context, "Email atau password tidak boleh kosong.", Toast.LENGTH_SHORT).show()
        } else if(password.length <= 8){
            Toast.makeText(context, "Password harus lebih panjang dari 8 karakter.", Toast.LENGTH_SHORT).show()
        } else {
            authViewModel.signup(email, password, "")
            Toast.makeText(context, "Pembuatan Akun berhasil.", Toast.LENGTH_SHORT).show()
            navController.navigate("RegisterScreenApplicants")
        }
    }) {
        Text("Buat Akun")
    }

}

