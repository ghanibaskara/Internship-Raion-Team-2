package com.example.internshipraionteam2.presentation.registration.screen.applicants

import android.net.Uri
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.ViewModel.SharedViewModel
import com.example.internshipraionteam2.data.Firebase.DataClass.UserData
import com.example.internshipraionteam2.data.Supabase.supabase.SupabaseViewModel
import com.example.internshipraionteam2.data.Supabase.supabase.utils.uriToByteArray
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

@Composable
fun CertificateScreenApplicants(
    navController: NavController,
    supabaseViewModel: SupabaseViewModel,
    sharedViewModel: SharedViewModel
){
    var pdfUri by remember { mutableStateOf<Uri?>(null) }

    var fname: String by remember { mutableStateOf("") } // first name
    var lname: String by remember { mutableStateOf("") } // last name
    var phone: String by remember { mutableStateOf("") } // phone number
    var dob: String by remember { mutableStateOf("") } // date of birth
    var lor: String by remember { mutableStateOf("") } // location of residence
    val context = LocalContext.current

    val auth = FirebaseAuth.getInstance().currentUser
    val uid = auth?.uid ?: ""
    val email = auth?.email ?: ""
    var fileName by remember { mutableStateOf("") }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? -> pdfUri = uri

        uri?.let {
            val cursor = context.contentResolver.query(uri,null,null,null,null)
            cursor?.use {
                val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (it.moveToFirst()){
                    val displayNameIndex = it.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                    if (displayNameIndex != -1) {
                        fileName = it.getString(displayNameIndex)
                        Toast.makeText(context, "Selected file: $fileName", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(top = 94.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current

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
                Icon(
                    painterResource(R.drawable.ellipse_filled),
                    contentDescription = "",
                    tint = buttonfocus
                )
                Text(text = "1",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
            Icon(
                painterResource(R.drawable.rectangle_filled),
                contentDescription = "",
                tint = buttonfocus
            )
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painterResource(R.drawable.ellipse_filled),
                    contentDescription = "",
                    tint = buttonfocus)
                Text(text = "2",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
            Icon(
                painterResource(R.drawable.rectangle_filled),
                contentDescription = "",
                tint = buttonfocus)
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painterResource(R.drawable.ellipse_26),
                    contentDescription = "",
                    tint = buttonfocus)
                Text(text = "3",
                    fontSize = 24.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Sertifikasi*",
            fontSize = 24.sp,
            fontFamily = localFontFamily,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
            horizontalAlignment = Alignment.Start) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(149.dp)
                .clickable {
                    launcher.launch("application/pdf")
                }){
                Icon(painterResource(R.drawable.rectangle_796),
                    contentDescription = "Certificate column")
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(painterResource(R.drawable.ic_add_circle),
                        contentDescription = "add circle",
                        modifier = Modifier.size(48.dp))
                    if (pdfUri == null){
                        Text(text = "Unggah berkas sertifikat Anda",
                            fontSize = 14.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.Normal)
                    } else {
                        Text(text = fileName,
                            fontSize = 14.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 16.dp))
                    }

                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text("*Ketentuan berkas sertifikasi",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ellipse_28),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text("Opsional (tidak wajib ada)",
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ellipse_28),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text("Format berkas: PDF",
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ellipse_28),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text("Format nama berkas: Nama lengkap_sertifikasi.pdf",
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ellipse_28),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text("Ukuran berkas maksimum: 5Mb",
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(134.dp))
        }
        Button(onClick = {
            navController.navigate("SummaryScreenApplicants")
            val pdfByteArray = pdfUri?.uriToByteArray(context)
            pdfByteArray?.let {
                supabaseViewModel.uploadFIle("pdf", fileName.removeSuffix(".pdf"), it)
            }

            val userData = UserData(
                fname = fname,
                lname = lname,
                phone = phone,
                dob = dob,
                lor = lor,
                email = email ?: "",
                uid = uid,
                biodataisfilled = true,
                certificateurl = supabaseViewModel.getFileUrl("pdf", fileName),
                certificatefilename = fileName

            )
            val documentRef = Firebase.firestore.collection("biodata").document(uid)

            documentRef.update("certificateurl", userData.certificateurl)
            documentRef.update("certificatfilename", fileName)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .size(width = 0.dp, height = 41.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonfocus)
        ) {
            Text("Selanjutnya",
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.Bold)
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