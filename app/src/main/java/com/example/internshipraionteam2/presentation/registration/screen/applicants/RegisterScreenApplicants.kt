package com.example.internshipraionteam2.presentation.registration.screen.applicants

import android.content.Context
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.data.network.SharedViewModel
import com.example.internshipraionteam2.data.network.UserData
import com.example.internshipraionteam2.reusable.BiodataTextField
import com.example.internshipraionteam2.reusable.RegisterTextField
import kotlin.coroutines.coroutineContext


@Composable
fun RegisterScreenApplicants(
    navController: NavController,
    sharedViewModel: SharedViewModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        var fname by rememberSaveable { mutableStateOf("") } // first name
        var lname by rememberSaveable { mutableStateOf("") } // last name
        var phone by rememberSaveable { mutableStateOf("") } // phone number
        var dob by rememberSaveable { mutableStateOf("") } // date of birth
        var lor by rememberSaveable { mutableStateOf("") } // location of residence

        Text("Register Applicants",
            fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))

        BiodataTextField(fname, onValueChange = {fname = it}, label = "first name")

        Spacer(modifier = Modifier.height(8.dp))

        BiodataTextField(lname, onValueChange = {lname = it}, label = "last name")

        Spacer(modifier = Modifier.height(8.dp))

        BiodataTextField(phone, onValueChange = {phone = it}, label = "phone")

        Spacer(modifier = Modifier.height(8.dp))

        BiodataTextField(dob, onValueChange = {dob = it}, label = "date of birth")

        Spacer(modifier = Modifier.height(8.dp))

        BiodataTextField(lor, onValueChange = {lor = it}, label = "location of birth")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            val userData = UserData(
                fname = fname,
                lname = lname,
                phone = phone,
                dob = dob,
                lor = lor
            )

            sharedViewModel.saveData(userData = userData, context = context)

            navController.navigate("HomeScreenApplicants")}) {
            Text("Register as Applicant")
        }
    }
}