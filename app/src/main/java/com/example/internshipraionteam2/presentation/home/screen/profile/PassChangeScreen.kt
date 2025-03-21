package com.example.internshipraionteam2.presentation.home.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Preview
@Composable
fun PassChangeScreen(
//    navController: NavController
) {
    var color1 = buttonfocus
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(start = 32.dp, end = 32.dp, top = 94.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(modifier = Modifier.clickable {
//            navController.popBackStack()
            },painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "")
        }

        Spacer(modifier = Modifier.height(43.dp))

        Text("Ubah kata sandi",
            fontSize = 24.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600)

        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Masukkan kata sandi lama",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( password,onValueChange = {password = it},singleLine = true,
            trailingIcon = { Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "") },
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color1,
                unfocusedBorderColor = color1,
            )
            ,modifier = Modifier.fillMaxWidth().height(40.dp))

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Masukkan kata sandi baru",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( password,onValueChange = {password = it},singleLine = true,
            trailingIcon = { Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "") },
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color1,
                unfocusedBorderColor = color1,
            )
            ,modifier = Modifier.fillMaxWidth().height(40.dp))

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Konfirmasi kata sandi baru",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( password,onValueChange = {password = it},singleLine = true,
            trailingIcon = { Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "") },
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color1,
                unfocusedBorderColor = color1,
            )
            ,modifier = Modifier.fillMaxWidth().height(40.dp))

        Spacer(modifier = Modifier.height(80.dp))

        Button(onClick = {},
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(buttonfocus)) {
            Text("Simpan",
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily
            )
        }
    }
}