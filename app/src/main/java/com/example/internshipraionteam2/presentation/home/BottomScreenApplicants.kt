package com.example.internshipraionteam2.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.ViewModel.AuthState
import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
import com.example.internshipraionteam2.presentation.navigation.NavItem
import com.example.internshipraionteam2.reusable.buttonfocus
import com.example.internshipraionteam2.ui.theme.bordercolor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomScreenApplicants(
    navController: NavController, authViewModel: AuthViewModel
) {
    val navItemList = listOf(
        NavItem(painter = painterResource(R.drawable.home)),
        NavItem(painter = painterResource(R.drawable.search_circle)),
        NavItem(painter = painterResource(R.drawable.folder)),
        NavItem(painter = painterResource(R.drawable.calendar)),
        NavItem(painter = painterResource(R.drawable.account_circle_filled_24px))
    )

    var selectedIndex by remember {
        mutableStateOf(0)
    }


//    val authState = authViewModel.authState.observeAsState()
//
//    LaunchedEffect(authState.value) {
//        when (authState.value) {
//            is AuthState.Unauthenticated -> navController.navigate("UserOption")
//            else -> Unit
//        }
//    }

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = -10.dp), // digunakan untuk menaikan bottom nav bar ke atas
                contentAlignment = Alignment.BottomCenter
            ) {
                Surface(
                    modifier = Modifier
                        .shadow(20.dp, shape = RoundedCornerShape(30.dp))
                        .fillMaxWidth(0.9f)
                        .height(50.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.White),
                    color = Color.Transparent
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        navItemList.forEachIndexed { index, navItem ->
                            NavigationBarItem(
                                selected = selectedIndex == index,
                                onClick = { selectedIndex = index },
                                icon = { Icon(painter = navItem.painter,
                                    contentDescription = "Icon",
                                    tint = if (selectedIndex == index) Color(0xFF6F4A31) else Color.Gray
                                ) },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color(0xFF5C3E29),
                                    unselectedIconColor = Color(0xFF6F4A31),
                                    indicatorColor = Color.Transparent
                                )
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        ContentScreen(modifier = Modifier.padding(paddingValues),
            selectedIndex,
            navController = navController,
            authViewModel = authViewModel)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,
                  selectedIndex : Int,
                  navController: NavController,
                  authViewModel: AuthViewModel) {
    when(selectedIndex){
        0-> HomeScreenApplicants(navController = navController, authViewModel = authViewModel)
        1-> SearchScreen()
        2-> FolderScreen()
        3-> CalenderScreen()
        4-> ProfileScreenApplicants(
            navController = navController)
    }
}