package com.example.internshipraionteam2.presentation.home.screen.profile

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.localFontFamily

//@Preview
@Composable
fun ChatScreen(
    navController: NavController
) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(91.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }, painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                "Cafe Laluna Space",
                fontWeight = FontWeight.W700,
                fontFamily = localFontFamily,
                fontSize = 28.sp,
                color = Color.Black
            )
        }

        Text(
            "Online",
            fontWeight = FontWeight.W600,
            fontFamily = localFontFamily,
            fontSize = 16.sp,
            color = Color.Green
        )
        Divider(color = Color.Gray.copy(alpha = 0.5f))
        Text(
            "Hari ini",
            fontWeight = FontWeight.W400,
            fontFamily = localFontFamily,
            fontSize = 14.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(13.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .height(112.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                "13.00",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )

            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier.height(70.dp)
                    .width(202.dp)

            ) {
                Text(
                    "Selamat siang, saya ingin bertanya perihal lamaran yang saya kirimkan",
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp, start = 12.dp)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Box(contentAlignment = Alignment.Center){
            Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "")
            Icon(painter = painterResource(R.drawable.laluna_caffee), contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.size(30.dp))
            }

            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier.height(50.dp)
                    .width(202.dp)

            ) {
                Text(
                    "Selamat siang, ada yang bisa kamu bantu?",
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp, start = 12.dp)
                )
            }
            Text(
                "13.00",
                fontWeight = FontWeight.W400,
                fontFamily = localFontFamily,
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(410.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Ketik pesan",
                fontFamily = localFontFamily,
                color = Color.Gray) },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
            Icon(painter = painterResource(R.drawable.paper_airplane), contentDescription = "", tint = Color.Unspecified)
            }
        )
    }
}