package com.example.internshipraionteam2.presentation.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.internshipraionteam2.R
import com.example.internshipraionteam2.data.Firebase.DataClass.CafeDetails
import com.example.internshipraionteam2.data.Firebase.ViewModel.ApplicantsViewModel
import com.example.internshipraionteam2.presentation.home.elements.VacancyCard


import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
//    authViewModel: AuthViewModel
    applicantsViewModel: ApplicantsViewModel = viewModel()
) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState()
    var showBottomsheet by remember { mutableStateOf(false) }

    val cafeDetailsList = remember { mutableStateListOf<CafeDetails>() }
    var selectedCafeDetails by remember { mutableStateOf<CafeDetails?>(null) }

    val searchHistory = listOf(
        "roketto",
        "jokopi",
        "kopi 24 jam",
        "lafayette",
        "CW coffee",
        "AADK",
        "Muraco",
        "Nakoa",
        "vosco",
        "labore coffee eatery"
    )

    LaunchedEffect(applicantsViewModel.cafeid.value.cafeUid) {
        cafeDetailsList.clear() // Kosongkan daftar sebelum mengambil data baru
        for (cafeuid in applicantsViewModel.cafeid.value.cafeUid) {
            applicantsViewModel.getCafesData(cafeuid) { data ->
                cafeDetailsList.add(data)
            }
        }
    }

    val filteredItems = searchHistory.filter { it.contains(query, ignoreCase = true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // hanya untuk preview
            .padding(top = 94.dp, start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "Siap melangkah",
                fontSize = 28.sp,
                fontWeight = FontWeight.W700,
                fontFamily = localFontFamily
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "ke karier baru?",
                fontSize = 28.sp,
                fontWeight = FontWeight.W700,
                fontFamily = localFontFamily
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        DockedSearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { newQuery ->
                println("search here $newQuery")
            },
            active = active,
            onActiveChange = {
                active = it
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "")
            },
            placeholder = {
                Text("search here")
            },
            colors = SearchBarDefaults.colors(containerColor = Color.White),
            modifier = Modifier.border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(30.dp)
            ),
            trailingIcon = if (active) {
                {
                    IconButton(onClick = {
                        if (query.isEmpty()) query = "" else active = false
                    }) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "")
                    }
                }
            } else null
        ) {
            LazyColumn {
                items(filteredItems) { item ->
                    Text(
                        text = item,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Lowongan Unggulan",
            fontWeight = FontWeight.W600,
            fontSize = 24.sp,
            fontFamily = localFontFamily
        )

        Spacer(modifier = Modifier.height(20.dp))


        Card(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(156.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF6F4A31))
                    .padding(horizontal = 14.dp, vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier.height(50.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ellipse_filled),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Dekker Koffie",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.W700
                        )
                        Text(
                            "Lowokwaru",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.W400
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Barista",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W700
                    )

                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            "Rp5 juta/bulan",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.W700
                        )
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                painter = painterResource(R.drawable.ellipse_4),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(20.dp)
                            )
                            Icon(
                                painter = painterResource(R.drawable.ic_arrow_right),
                                contentDescription = "",
                                tint = buttonfocus
                            )
                        }

                    }
                }


                Spacer(modifier = Modifier.height(12.dp))

                Row() {
                    Icon(
                        painter = painterResource(R.drawable.tag_fulltime), contentDescription = "",
                        tint = Color.White
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Daftar Lowongan",
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            fontFamily = localFontFamily
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentPadding = PaddingValues(bottom = 55.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(cafeDetailsList) { cafeDetails ->
                VacancyCard(
                    cafeDetails.job,
                    cafeDetails.name,
                    cafeDetails.salary,
                    cafeDetails.location,
                    cafeDetails.uid,
                    onClick = {
                        showBottomsheet = true
                    selectedCafeDetails = cafeDetails})
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        if (showBottomsheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomsheet = false
                },
                sheetState = sheetState,
                containerColor = buttonfocus
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            "Detail pekerjaan",
                            fontWeight = FontWeight.W600,
                            fontFamily = localFontFamily,
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    selectedCafeDetails?.let {
                        cafe ->
                        Row(
                            modifier = Modifier.height(50.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ellipse_16),
                                    contentDescription = "",
                                    tint = Color.Unspecified
                                )
                                Image(
                                    painter = painterResource(R.drawable.laluna_caffee),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(38.dp)
                                        .clip(RoundedCornerShape(30.dp))
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    cafe.job,
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontFamily = localFontFamily,
                                    fontWeight = FontWeight.W700
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Text(
                                        cafe.name,
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontFamily = localFontFamily,
                                        fontWeight = FontWeight.W400
                                    )

                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(
                                        painter = painterResource(R.drawable.ellipse_46),
                                        contentDescription = "",
                                        tint = Color.Unspecified
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))

                                    Text(
                                        cafe.location,
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontFamily = localFontFamily,
                                        fontWeight = FontWeight.W400
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.5.dp))

                        Row() {
                            Icon(
                                painter = painterResource(R.drawable.tag_fulltime),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            "Deskripsi posisi",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.W600
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            cafe.positiondescription,
                            color = Color.White,
                            fontSize = 12.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.W400
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Button(
                            onClick = {
                                navController.navigate("WorkDetail/${cafe.uid}")
                            },
                            colors = ButtonDefaults.buttonColors(Color.White),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                "Lihat detail pekerjaan",
                                color = buttonfocus,
                                fontSize = 16.sp,
                                fontFamily = localFontFamily,
                                fontWeight = FontWeight.W600
                            )
                        }
                    }
                }
            }
        }
                    }

}