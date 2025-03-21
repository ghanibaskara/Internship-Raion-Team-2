package com.example.internshipraionteam2.presentation.home.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.localFontFamily


@Composable
fun EventCard(modifier: Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
        .height(262.dp)
        .width(234.dp)
        .padding(end = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
            Image(painter = painterResource(R.drawable.dummy_image_coffee),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .clip(shape = RoundedCornerShape(10.dp)))

            Spacer(modifier = Modifier.height(8.dp))

            Text("Latte Art & Brewing Class",
                fontWeight = FontWeight.W600,
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                color = Color.Black)

            Spacer(modifier = Modifier.height(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(painter = painterResource(R.drawable.ic_cafe), contentDescription = "",
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Sejenak Coffe",
                    fontSize = 12.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(painter = painterResource(R.drawable.ic_location), contentDescription = "",
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Lowokwaru, Malang",
                    fontSize = 12.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(R.drawable.ic_clock), contentDescription = "",
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Selasa, 11 Maret (13.00-selesai)",
                    fontSize = 11.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Icon(painter = painterResource(R.drawable.tag_barista), contentDescription = "",
                tint = Color.Unspecified)
        }
    }
}