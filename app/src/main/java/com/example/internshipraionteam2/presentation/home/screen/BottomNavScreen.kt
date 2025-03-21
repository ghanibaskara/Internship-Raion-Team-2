//package com.example.internshipraionteam2.presentation.home
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.NavigationBarItemDefaults
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.SearchBar
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHost
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.internshipraionteam2.R
//import com.example.internshipraionteam2.data.ViewModel.AuthState
//import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
//import com.example.internshipraionteam2.presentation.navigation.NavItem
//import com.example.internshipraionteam2.ui.theme.localFontFamily
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BottomNavScreen(
//    navController: NavHostController = rememberNavController(),
//    authViewModel: AuthViewModel
//) {
//    val navItemList = listOf(
//        NavItem(painter = painterResource(R.drawable.home)),
//        NavItem(painter = painterResource(R.drawable.search_circle)),
//        NavItem(painter = painterResource(R.drawable.folder)),
//        NavItem(painter = painterResource(R.drawable.calendar)),
//        NavItem(painter = painterResource(R.drawable.account_circle_filled_24px))
//    )
//
//    var selectedIndex by remember {
//        mutableStateOf(0)
//    }
//
//    val authState = authViewModel.authState.observeAsState()
//
//    LaunchedEffect(authState.value) {
//        when (authState.value) {
//            is AuthState.Unauthenticated -> navController.navigate("UserOption")
//            else -> Unit
//        }
//    }
//    var query by remember { mutableStateOf("") }
//    var active by remember { mutableStateOf(false) }
//
//    val searchHistory = listOf("roketto", "jokopi", "kopi 24 jam", "lafayette", "CW coffee", "AADK", "Muraco", "Nakoa", "vosco", "labore coffee eatery")
//    val filteredItems = searchHistory.filter { it.contains(query, ignoreCase = true) }
//
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        bottomBar = {
//            Box(
//                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.BottomCenter
//            ){
//                Column(
//                    modifier = Modifier.fillMaxSize()
//                        .padding(top = 94.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Top
//                ) {
//                    Text(
//                        "Siap melangkah",
//                        fontSize = 28.sp,
//                        fontWeight = FontWeight.W700,
//                        fontFamily = localFontFamily
//                    )
//                }
//                Row(
//                    modifier = Modifier.fillMaxWidth().padding(start = 32.dp, end = 32.dp),
//                    horizontalArrangement = Arrangement.Start
//                ) {
//                    Text(
//                        "ke karier baru?",
//                        fontSize = 28.sp,
//                        fontWeight = FontWeight.W700,
//                        fontFamily = localFontFamily
//                    )
//                }
//
//                SearchBar(
//                    query = query,
//                    onQueryChange = { query = it },
//                    onSearch = { newQuery ->
//                        println("search here $newQuery")
//                    },
//                    active = active,
//                    onActiveChange = {
//                        active = it
//                    },
//                    leadingIcon = {
//                        Icon(imageVector = Icons.Filled.Search, contentDescription = "")
//                    },
//                    placeholder = {
//                        Text("search here")
//                    },
//                    trailingIcon = if (active) {
//                        {
//                            IconButton(onClick = {
//                                if (query.isEmpty()) query = "" else active = false
//                            }) {
//                                Icon(imageVector = Icons.Filled.Close, contentDescription = "")
//                            }
//                        }
//                    } else null
//                ) {
//                    LazyColumn {
//                        items(filteredItems) { item ->
//                            Text(
//                                text = item,
//                                fontSize = 18.sp,
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(8.dp)
//                            )
//                        }
//                    }
//                }
//                Surface(
//                    modifier = Modifier
//                        .fillMaxWidth(0.9f)
//                        .height(55.dp)
//                        .clip(RoundedCornerShape(50.dp))
//                        .shadow(10.dp, RoundedCornerShape(30.dp)),
//                    color = Color.Transparent
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(horizontal = 16.dp),
//                        horizontalArrangement = Arrangement.SpaceEvenly,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        navItemList.forEachIndexed { index, navItem ->
//                            NavigationBarItem(
//                                selected = selectedIndex == index,
//                                onClick = { selectedIndex = index },
//                                icon = {
//                                    Icon(
//                                        painter = navItem.painter,
//                                        contentDescription = "Icon"
//                                    )
//                                }, colors = NavigationBarItemDefaults.colors(
//                                    indicatorColor = Color.Transparent
//                                )
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    ) { paddingValues ->
//        NavHost(
//            navController = navController,
//            startDestination = "home",
//            modifier = Modifier.padding(paddingValues)
//        ) {
//            composable("home"){
//                HomeScreenApplicants(navController = navController, authViewModel = AuthViewModel())
//            }
//            composable("search"){
//                SearchScreen(navController = navController)
//            }
//            composable("folder"){
//                FolderScreen(navController = navController)
//            }
//            composable("calender"){
//                CalenderScreen(navController = navController)
//            }
//            composable("profile"){
//                ProfileScreenApplicants(navController = navController)
//            }
//        }
//    }
//}