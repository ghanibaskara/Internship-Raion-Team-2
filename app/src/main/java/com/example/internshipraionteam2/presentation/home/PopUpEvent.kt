package com.example.internshipraionteam2.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily


@Composable
fun PopUpEvent(
    onDismiss:() ->Unit,
) {
    AlertDialog(
        onDismissRequest =onDismiss,
        confirmButton = {},
        modifier = Modifier
            .height(493.dp)
            .fillMaxWidth()
            .padding(32.dp),
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(painter = painterResource(R.drawable.dialog_person),
                    contentDescription = "",
                    tint = Color.Unspecified)
            }
        },
        text = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text("Anda telah terdaftar",
                    fontSize = 16.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W700)

                Text("Jangan lupakan tanggal dan datang ke event!",
                    fontSize = 14.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W400,
                    )

                Button(onClick = {
                    onDismiss()
                },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(buttonfocus)
                ) {
                    Text("Kembali",
                        fontSize = 16.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W600)
                }
            }
        }
    )
}