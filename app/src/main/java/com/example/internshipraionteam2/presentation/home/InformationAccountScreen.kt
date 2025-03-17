package com.example.internshipraionteam2.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.network.SharedViewModel
import com.example.internshipraionteam2.ui.theme.bordercolor
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily
import com.example.internshipraionteam2.ui.theme.maincolor

@Composable
fun InformationAccountScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel = viewModel()
) {
    var color = buttonfocus
    var email by rememberSaveable { mutableStateOf("") }
    val getData = sharedViewModel.state.value
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
                navController.navigate("ProfileScreenApplicants")
            },painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "")
        }

        Spacer(modifier = Modifier.height(43.dp))

        Text("Informasi akun",
            fontSize = 24.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.W600)

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Alamat email",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( getData.email,onValueChange = {getData.email = it},singleLine = true,
            trailingIcon = {Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "")},
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color,
                unfocusedBorderColor = color,
            )
            ,modifier = Modifier.fillMaxWidth().height(50.dp))

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Nomor telepon",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( getData.phone,onValueChange = {getData.phone = it},singleLine = true,
            trailingIcon = {Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "")},
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color,
                unfocusedBorderColor = color,
            )
            ,modifier = Modifier.fillMaxWidth().height(50.dp))

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Tanggal lahir",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( getData.dob,onValueChange = {getData.dob = it},singleLine = true,
            trailingIcon = {Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "")},
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color,
                unfocusedBorderColor = color
            )
            ,modifier = Modifier.fillMaxWidth().height(50.dp))

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Lokasi tempat tinggal",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( getData.lor,onValueChange = {getData.lor = it},singleLine = true,
            trailingIcon = {Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "")},
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color,
                unfocusedBorderColor = color
            )
            ,modifier = Modifier.fillMaxWidth().height(50.dp))

        Spacer(modifier = Modifier.height(44.dp))

        Button(onClick = {

        },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(buttonfocus)) {
            Text("Simpan",
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                fontFamily = localFontFamily)
        }
    }
}