package com.example.internshipraionteam2.reusable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.data.local.localFontFamily
import com.example.internshipraionteam2.ui.theme.bordercolor
import com.example.internshipraionteam2.ui.theme.maincolor

@Composable
fun useroptionbutton(vector : Painter, text : String, padding : Int) {
    var stroke by remember { mutableStateOf(1.dp) }
    var border by remember { mutableStateOf(bordercolor) }
    var font by remember { mutableStateOf(FontWeight.Normal) }


    Box(
        modifier = Modifier
            .height(138.dp)
            .width(294.dp)
            .clickable {}
            .border(
                BorderStroke(stroke, border),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = vector,
                "",
                tint = Color.Unspecified,
                modifier = Modifier.padding(start = padding.dp,end = 22.dp)
            )
            Text(
                text,
                fontSize = 20.sp,
                fontFamily = localFontFamily,
                fontWeight = font,
                color = maincolor
            )
        }
    }
}