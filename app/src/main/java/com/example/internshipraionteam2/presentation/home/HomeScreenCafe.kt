package com.example.internshipraionteam2.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.internshipraionteam2.data.local.NavItem

@Composable
fun HomeScreenCafe(navController: NavController) {

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Notification", Icons.Default.Notifications),
        NavItem("Sttings", Icons.Default.Settings)
    )

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index},
                    icon = {
                        Icon(imageVector = navItem.icon, contentDescription = "Icon")
                    },
                    label = {
                        Text(text = navItem.label)
                    }
                )
                }
            }
        }, content = { 
            paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {}
        }
    )
}