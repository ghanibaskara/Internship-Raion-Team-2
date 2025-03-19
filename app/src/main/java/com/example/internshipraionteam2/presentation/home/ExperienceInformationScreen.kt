package com.example.internshipraionteam2.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Composable
fun ExperienceInformationScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel = viewModel()
) {
    var color1 = buttonfocus
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
        Box(
            contentAlignment = Alignment.BottomEnd
        ){
            Image(painter = painterResource(R.drawable.dummy),
                contentDescription = "",
                modifier = Modifier.size(width = 176.dp, height = 176.dp)
                    .clip(shape = RoundedCornerShape(90.dp)))
            Box(
                contentAlignment = Alignment.Center
            ){
                Icon(painter = painterResource(R.drawable.ellipse_4), contentDescription = "",
                    tint = Color.Unspecified)
                Icon(painter = painterResource(R.drawable.ic_photo_camera), contentDescription = "",
                    tint = Color.Unspecified)
            }




        }
        Spacer(modifier = Modifier.height(43.dp))

        Row() {
            Text(getData.fname,
                fontSize = 24.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W600)
            Spacer(modifier = Modifier.width(5.dp))
            Text(getData.lname,
                fontSize = 24.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W600)
            Icon(painter = painterResource(R.drawable.ic_pencilblack), contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(33.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Bio",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( email,onValueChange = {email = it},singleLine = true,
            trailingIcon = { Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "") },
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color1,
                unfocusedBorderColor = color1,
            )
            ,modifier = Modifier.fillMaxWidth().height(40.dp))

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Pengalaman",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( email,onValueChange = {email = it},singleLine = true,
            trailingIcon = { Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "") },
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color1,
                unfocusedBorderColor = color1,
            )
            ,modifier = Modifier.fillMaxWidth().height(40.dp))

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Tautan",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( email,onValueChange = {email = it},singleLine = true,
            trailingIcon = { Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "") },
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color1,
                unfocusedBorderColor = color1
            )
            ,modifier = Modifier.fillMaxWidth().height(40.dp))

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Gender",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField( email,onValueChange = {email = it},singleLine = true,
            trailingIcon = { Icon(painter = painterResource(R.drawable.ic_pencil), contentDescription = "") },
            shape = RoundedCornerShape(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color1,
                unfocusedBorderColor = color1
            )
            ,modifier = Modifier.fillMaxWidth().height(40.dp))

        Spacer(modifier = Modifier.height(44.dp))

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