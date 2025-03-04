package com.example.internshipraionteam2.presentation.registration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun UserOption(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(400.dp)
                .width(320.dp)
                .border(BorderStroke(2.dp, Color.White), shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {navController.navigate("LoginScreenApplicants")},
                    modifier = Modifier
                        .height(108.dp)
                        .width(300.dp)
                ) {
                    Text("Pencari Kerja")
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {navController.navigate("LoginScreenCafe")},
                    modifier = Modifier
                        .height(108.dp)
                        .width(300.dp)
                ) {
                    Text("Pelamar Kerja")
                }

            }
        }
    }
}

@Preview
@Composable
fun UserOptionPreview(modifier: Modifier = Modifier) {
    val NavController = rememberNavController()
    UserOption(NavController)
}

