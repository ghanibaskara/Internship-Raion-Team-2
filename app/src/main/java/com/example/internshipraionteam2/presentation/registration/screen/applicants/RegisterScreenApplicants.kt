package com.example.internshipraionteam2.presentation.registration.screen.applicants

import android.content.Context
import android.icu.util.Calendar
import android.widget.DatePicker
import android.widget.Space
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internshipraionteam2.R

import com.example.internshipraionteam2.data.Firebase.ViewModel.ApplicantsViewModel
import com.example.internshipraionteam2.data.Firebase.DataClass.UserData
import com.example.internshipraionteam2.presentation.registration.elements.BiodataTextField
import com.example.internshipraionteam2.presentation.registration.elements.DobTextField
import com.example.internshipraionteam2.presentation.registration.elements.PhoneTextField
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily
import com.example.internshipraionteam2.ui.theme.maincolor
import com.google.firebase.auth.FirebaseAuth
import java.util.Date
import kotlin.coroutines.coroutineContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreenApplicants(
    navController: NavController,
    applicantsViewModel: ApplicantsViewModel = viewModel()
) {
    val year: Int
    val month: Int
    val day: Int
    val context = LocalContext.current

    val calender = Calendar.getInstance()
    year = calender.get(Calendar.YEAR)
    month = calender.get(Calendar.MONTH)
    day = calender.get(Calendar.DAY_OF_MONTH)
    calender.time = Date()

    val date = remember { mutableStateOf("") }
    val datePickerDialog = remember {
        android.app.DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                date.value = "$dayOfMonth ${month+1} $year"
            }, year, month, day

        )
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(top = 94.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var fname by rememberSaveable { mutableStateOf("") } // first name
        var lname by rememberSaveable { mutableStateOf("") } // last name
        var phone by rememberSaveable { mutableStateOf("") } // phone number
//        var dob by rememberSaveable { mutableStateOf("") } // date of birth
        var lor by rememberSaveable { mutableStateOf("") } // location of residence
        val context = LocalContext.current

        val auth = FirebaseAuth.getInstance().currentUser
        val email = auth?.email ?: ""
        val uid = auth?.uid ?: ""

        var isFilled by remember { mutableStateOf(false) }
        var color by remember { mutableStateOf(Color(0xFFEDEDED)) }
        var fontcolor by remember { mutableStateOf(Color(0xFF9E9E9E)) }


        if (fname != ""&& lname != ""&& phone != ""&& date.value != "" && lor != ""){
            color = maincolor
            fontcolor = Color.White
            isFilled = true
        } else {
            color = Color(0xFFEDEDED)
            fontcolor = Color(0xFF9E9E9E)
            isFilled = false

        }

        Row(modifier = Modifier.fillMaxWidth(),
            ) {
            Spacer(modifier = Modifier.width(24.dp))
            Icon(modifier = Modifier.clickable {
                navController.popBackStack()
            },painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "arrow back")
            Spacer(modifier = Modifier.width(80.dp))
            Text("Unggah berkas",
                fontSize = 20.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color.Black
                )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            Box(contentAlignment = Alignment.Center) {
                Icon(painterResource(R.drawable.ellipse_25),
                    contentDescription = "",
                    tint = buttonfocus)
                Text(text = "1",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold)
            }
            Icon(painterResource(R.drawable.rectangle_794),
                contentDescription = "")
            Box(contentAlignment = Alignment.Center) {
                Icon(painterResource(R.drawable.ellipse_26),
                    contentDescription = "" )
                Text(text = "2",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold)
            }
            Icon(painterResource(R.drawable.rectangle_794),
                contentDescription = "")
            Box(contentAlignment = Alignment.Center) {
                Icon(painterResource(R.drawable.ellipse_26),
                    contentDescription = "",
                    tint = buttonfocus)
                Text(text = "3",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Biodata",
            fontSize = 24.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = "Nama depan",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp))

            BiodataTextField(fname, onValueChange = {fname = it}, label = "Masukkan nama depan Anda", icons = Icons.Filled.AccountCircle)

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Nama belakang",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp))

            BiodataTextField(lname, onValueChange = {lname = it}, label = "Masukkan nama belakang Anda", icons = Icons.Filled.AccountCircle)

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Tanggal lahir",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp))

            DobTextField(date.value, onValueChange = {date.value = it}, label = "Masukkan tanggal lahir Anda", icons = Icons.Filled.DateRange, onItemClick = {datePickerDialog.show()})

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Nomor telepon",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp))

            PhoneTextField(phone, onValueChange = {phone = it}, label = "Masukkan nomor telepon Anda", icons = Icons.Filled.Call)

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Lokasi tinggal",
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp))

            BiodataTextField(lor, onValueChange = {lor = it}, label = "Masukkan lokasi tinggal Anda", icons = Icons.Filled.Place)

            Spacer(modifier = Modifier.height(16.dp))

        }
        Button(onClick = {

            val userData = UserData(
                fname = fname,
                lname = lname,
                phone = phone,
                dob = date.value,
                lor = lor,
                email = email ?: "",
                uid = uid,
                biodataisfilled = false

            )

            applicantsViewModel.saveApplicantsBiodata(userData = userData, context = context)


            navController.navigate("CvScreenApplicants")},
            modifier = Modifier.fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .size(width = 0.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = color),
            enabled = isFilled
        ) {
            Text("Selanjutnya",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold,
                color = fontcolor)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                navController.navigate("BottomScreenApplicants")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            Text(text = "Lewati",
                fontSize = 14.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Normal,
                color = Color(0x61000000)
            )
        }
    }
}