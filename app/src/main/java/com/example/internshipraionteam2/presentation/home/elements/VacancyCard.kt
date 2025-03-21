package com.example.internshipraionteam2.presentation.home.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.localFontFamily


@Composable
fun VacancyCard(job: String, name: String, salary: String, location: String,cafeuid: String, onClick: () -> Unit) {
    Card(
        onClick = {onClick()},
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.height(133.dp)
            .width(175.dp)
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(painter = painterResource(R.drawable.ic_location), contentDescription = "",
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(4.dp))
                Text(location,
                    fontSize = 12.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(38.dp),
                horizontalArrangement = Arrangement.Start
            ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(painter = painterResource(R.drawable.ellipse_16), contentDescription = "",
                    tint = Color.Unspecified)
                Image(painter = painterResource(R.drawable.laluna_caffee), contentDescription = "",
                    modifier = Modifier.size(38.dp)
                        .clip(RoundedCornerShape(30.dp)))
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(job,
                    fontSize = 16.sp,
                    fontFamily = localFontFamily,
                    fontWeight = FontWeight.W700,
                    color = Color.Black
                )
                Text(name,
                fontSize = 12.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W400,
                color = Color.Black
                )
            }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(salary,
                fontSize = 14.sp,
                fontFamily = localFontFamily,
                fontWeight = FontWeight.W600,
                color = Color.Black
            )
        }
    }
}