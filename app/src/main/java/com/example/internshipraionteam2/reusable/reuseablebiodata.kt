package com.example.internshipraionteam2.reusable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.ui.theme.localFontFamily
import com.example.internshipraionteam2.ui.theme.maincolor

//Text field for biodata register
@Composable
fun BiodataTextField(name: String, onValueChange : (String) -> Unit, label: String, icons : ImageVector) {
    var color by remember { mutableStateOf(Color.Gray) }
    if (name == "") color = Color.Gray else color = maincolor
    OutlinedTextField(
        name,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {
            Text(label, fontFamily = localFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
        },
        leadingIcon = {
            Icon(icons, contentDescription = "", tint = color)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .padding(top = 4.dp)
            .fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = color,
            focusedLabelColor = color,
            unfocusedBorderColor = color,
            focusedBorderColor = color,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black

        )
    )
}
@Composable
fun PhoneTextField(name: String, onValueChange : (String) -> Unit, label: String, icons : ImageVector) {
    var color by remember { mutableStateOf(Color.Gray) }
    if (name == "") color = Color.Gray else color = maincolor
    OutlinedTextField(
        name,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {
            Text(label, fontFamily = localFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
        },
        leadingIcon = {
            Icon(icons, contentDescription = "", tint = color)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .padding(top = 4.dp)
            .fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = color,
            focusedLabelColor = color,
            unfocusedBorderColor = color,
            focusedBorderColor = color,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black

        )
    )
}

@Composable
fun DobTextField(name: String, onValueChange : (String) -> Unit, label: String, icons : ImageVector,onItemClick: ()-> Unit) {
    var color by remember { mutableStateOf(Color.Gray) }
    if (name == "") color = Color.Gray else color = maincolor
    OutlinedTextField(
        name,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {
            Text(label, fontFamily = localFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp)
        },
        leadingIcon = {
            Icon(icons, contentDescription = "", tint = color)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .padding(top = 4.dp)
            .fillMaxWidth()
            .clickable { onItemClick() },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = color,
            focusedLabelColor = color,
            unfocusedBorderColor = color,
            focusedBorderColor = color,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black

        )
    )
}