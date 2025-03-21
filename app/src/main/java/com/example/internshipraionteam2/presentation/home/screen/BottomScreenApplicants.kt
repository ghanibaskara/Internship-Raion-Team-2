package com.example.internshipraionteam2.presentation.home.screen

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.ViewModel.AuthViewModel
import com.example.internshipraionteam2.presentation.home.screen.profile.ProfileScreenApplicants
import com.example.internshipraionteam2.presentation.navigation.NavItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomScreenApplicants(
    navController: NavController, authViewModel: AuthViewModel
) {
    val navItemList = listOf(
        NavItem(painter = painterResource(R.drawable.home), painterResource(R.drawable.ic_homefilled)),
        NavItem(painter = painterResource(R.drawable.search_circle), painterResource(R.drawable.ic_searchfilled)),
        NavItem(painter = painterResource(R.drawable.folder), painterResource(R.drawable.ic_folderfilled)),
        NavItem(painter = painterResource(R.drawable.calendar), painterResource(R.drawable.ic_calendarfilled)),
        NavItem(painter = painterResource(R.drawable.account_circle_filled_24px), painterResource(R.drawable.ic_account_circlefilled))
    )

    var selectedIndex by remember {
        mutableStateOf(0)
    }

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
                                icon = {if (index == selectedIndex) {
                                    Icon(painter = navItem.painter2, contentDescription = "")}
                                        else Icon(painter = navItem.painter, contentDescription = "")
                                       },
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
                  authViewModel: AuthViewModel
) {
    when(selectedIndex){
        0-> HomeScreenApplicants(navController = navController, authViewModel = authViewModel)
        1-> SearchScreen(navController = navController)
        2-> FolderScreen(navController = navController)
        3-> CalenderScreen(navController= navController)
        4-> ProfileScreenApplicants(navController = navController)
    }
}