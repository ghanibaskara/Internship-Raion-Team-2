package com.example.internshipraionteam2.presentation.registration.screen.applicants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.reusable.BiodataTextField

@Composable
fun RegisterScreenApplicants(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var fname by remember { mutableStateOf("") } // first name
        var lname by remember { mutableStateOf("") } // last name
        var phone by remember { mutableStateOf("") } // phone number
        var dob by remember { mutableStateOf("") } // date of birth
        var lor by remember { mutableStateOf("") } // location of residence

        Text("Register Applicants",
            fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))

        BiodataTextField(fname, onValueChange = {fname = it}, label = "name")

        Spacer(modifier = Modifier.height(8.dp))

        BiodataTextField(lname, onValueChange = {lname = it}, label = "name")

        Spacer(modifier = Modifier.height(8.dp))

        BiodataTextField(phone, onValueChange = {phone = it}, label = "name")

        Spacer(modifier = Modifier.height(8.dp))

        BiodataTextField(dob, onValueChange = {dob = it}, label = "age")

        Spacer(modifier = Modifier.height(8.dp))

        BiodataTextField(lor, onValueChange = {lor = it}, label = "age")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {navController.navigate("HomeScreenApplicants")}) {
            Text("Register as Applicant")
        }

    }
}