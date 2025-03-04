package com.example.internshipraionteam2.reusable

import androidx.compose.animation.expandVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.ui.theme.borderbutton
import com.example.internshipraionteam2.ui.theme.colortext
import com.example.internshipraionteam2.ui.theme.*


@Composable
fun buttonmain() {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonmain),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark")
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Button")
    }
}

@Composable
fun buttonhover() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonhover),
        shape = RoundedCornerShape(6.dp)
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark")
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Button")
    }
}

@Composable
fun buttonfocus() {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonhover),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(3.dp, borderbutton)
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark")
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Button")
    }
}

@Composable
fun buttonpressed() {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonpressed),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(3.dp, borderbutton)
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark")
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Button")
    }
}

@Composable
fun buttonwhite() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.borderbutton),
        shape = RoundedCornerShape(6.dp)
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark",
            tint = colortext)
        Spacer(modifier = Modifier.width(4.dp))
        Text(color = colortext,
            text = "Button")
    }
}

@Composable
fun buttonmainwm() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonmain),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(text = "Button")
    }
}

@Composable
fun buttonhoverwm() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonhover),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(text = "Button")
    }
}

@Composable
fun buttonfocuswm() {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonhover),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(3.dp, borderbutton)
    ) {
        Text(text = "Button")
    }
}

@Composable
fun buttonpressedwm() {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.buttonpressed),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(3.dp, borderbutton)
    ) {
        Text(text = "Button")
    }
}

@Composable
fun buttonwhitewm() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = com.example.internshipraionteam2.ui.theme.borderbutton),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(color = colortext,
            text = "Button")
    }
}

@Composable
fun bmmain() {
    IconButton(
        onClick = { },
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(buttonmain)
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark",
            tint = Color.White,
            modifier = Modifier.size(width = 48.dp, height = 60.dp))
    }
}

@Composable
fun bmhover() {
    IconButton(
        onClick = { },
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(buttonhover),

        ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark",
            tint = Color.White,
            modifier = Modifier.size(width = 48.dp, height = 60.dp))
    }
}

@Composable
fun bmfocus() {
    IconButton (
        onClick = { },
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(buttonfocus),
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark",
            tint = Color.White,
            modifier = Modifier.size(width = 48.dp, height = 60.dp))
    }
}

@Composable
fun bmpressed() {
    IconButton(
        onClick = { },
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(buttonpressed),
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark",
            tint = Color.White,
            modifier = Modifier.size(width = 48.dp, height = 60.dp))
    }
}

@Composable
fun bmwhite() {
    IconButton(
        onClick = { },
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(borderbutton)
    ) {
        Icon(painter = painterResource(R.drawable.ic_bookmark),
            contentDescription = "bookmark",
            tint = colortext,
            modifier = Modifier.size(width = 48.dp, height = 60.dp))
    }
}
@Preview
@Composable
private fun ButtonPrev() {
    Column {
        bmfocus()
        buttonhover()
        buttonmain()
        buttonpressed()
        buttonpressedwm()
        buttonwhite()
        buttonfocus()
        buttonfocuswm()
        buttonhoverwm()
        buttonmainwm()
        buttonwhitewm()
        bmhover()
        bmwhite()
        bmpressed()
        bmmain()
    }
}


