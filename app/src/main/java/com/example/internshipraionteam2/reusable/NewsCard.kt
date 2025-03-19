package com.example.internshipraionteam2.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.localFontFamily

@Preview
@Composable
fun NewsCard() {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .height(110.dp)
            .width(271.dp)
            .padding(end = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(painter = painterResource(R.drawable.dummy_berita), contentScale = ContentScale.Crop , contentDescription = "",
                modifier = Modifier.fillMaxHeight()
                    .width(81.dp)
                    .clip(shape = RoundedCornerShape(10.dp)))

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.fillMaxSize()) {
                Text("Inovasi Kafe: Mesin",
                    fontWeight = FontWeight.W700,
                    fontFamily = localFontFamily,
                    fontSize = 14.sp,
                    color = Color.Black)
                Text("Kopi & Digitalisasi",
                    fontWeight = FontWeight.W700,
                    fontFamily = localFontFamily,
                    fontSize = 14.sp,
                    color = Color.Black)
                Spacer(modifier = Modifier.height(12.dp))
                Text("LattePress",
                    fontWeight = FontWeight.W500,
                    fontFamily = localFontFamily,
                    fontSize = 12.sp,
                    color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text("25 Februari 2025",
                    fontWeight = FontWeight.W400,
                    fontFamily = localFontFamily,
                    fontSize = 12.sp,
                    color = Color.Black)
            }
        }
    }
}