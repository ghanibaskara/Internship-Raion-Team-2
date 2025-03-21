package com.example.internshipraionteam2.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internshipraionteam2.presentation.home.elements.EventCard
import com.example.internshipraionteam2.presentation.home.elements.NowEventCard
import androidx.navigation.NavController
import com.example.internshipraionteam2.R

import com.example.internshipraionteam2.ui.theme.buttonfocus
import com.example.internshipraionteam2.ui.theme.localFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalenderScreen(
    navController: NavController
) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState()
    var showBottomsheet by remember { mutableStateOf(false) }

    var showDialog by remember { mutableStateOf(false) }
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
    val filteredItems = searchHistory.filter { it.contains(query, ignoreCase = true) }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(start = 32.dp, end = 32.dp, top = 64.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            "Event terbaru",
            fontWeight = FontWeight.W600,
            fontFamily = localFontFamily,
            fontSize = 32.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

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
                Text("Cari event")
            },
            colors = SearchBarDefaults.colors(containerColor = Color.White),
            modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.outline, shape = RoundedCornerShape(30.dp)),
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

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            "Dalam waktu dekat",
            fontWeight = FontWeight.W600,
            fontFamily = localFontFamily,
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow() {
            items(5){
            EventCard(modifier = Modifier)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Event hari ini",
            fontWeight = FontWeight.W700,
            fontFamily = localFontFamily,
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 60.dp)
        ) {
            items(4){
                NowEventCard(onItemClick = {showBottomsheet = true})
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        if (showBottomsheet){
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomsheet = false
                },
                sheetState = sheetState,
                containerColor = buttonfocus
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.Start) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text("Detail",
                            fontWeight = FontWeight.W700,
                            fontFamily = localFontFamily,
                            fontSize = 28.sp,
                            color = Color.White)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text("Seminar Flow & Grow",
                            fontWeight = FontWeight.W700,
                            fontFamily = localFontFamily,
                            fontSize = 17.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(17.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_cafe),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Cafe Laluna Space",
                            fontWeight = FontWeight.W600,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_location),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Jl. Sigura-gura No.5, Lowokwaru, Malang",
                            fontWeight = FontWeight.W600,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_clock),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Sabtu, 15 Maret (13.00-selesai)",
                            fontWeight = FontWeight.W600,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_ticket),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Gratis",
                            fontWeight = FontWeight.W600,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(9.dp))

                    Text("Materi",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W700)

                    Spacer(modifier = Modifier.height(9.dp))

                    Text("Seminar ini membahas strategi menyusun workflow yang efektif untuk meningkatkan produktivitas dan efisiensi kerja, terutama dalam kolaborasi tim. Dengan workflow yang terstruktur, tim dapat bekerja lebih sinkron, mengurangi hambatan, dan mencapai hasil maksimal bersama",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W400)

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Pemateri",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W700)

                    Spacer(modifier = Modifier.height(7.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_user),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Rama Satria – CEO Startup Manajemen Workflow",
                            fontWeight = FontWeight.W400,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_user),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Jessica Anggraeni – HR Specialist & Team Productivity Expert",
                            fontWeight = FontWeight.W400,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(11.dp))

                    Text("Materi yang dibahas",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = localFontFamily,
                        fontWeight = FontWeight.W700)

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_book_open),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Strategi Menyusun Workflow yang Efektif untuk tim dan individu",
                            fontWeight = FontWeight.W400,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

//                    Spacer(modifier = Modifier.height(4.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_book_open),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Konsep Dasar Workflow & Manfaatnya dalam dunia kerja",
                            fontWeight = FontWeight.W400,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(3.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(painter = painterResource(R.drawable.ic_book_open),
                            contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))

                        Text("Teknologi & Tools Automasi untuk mempercepat alur kerja",
                            fontWeight = FontWeight.W400,
                            fontFamily = localFontFamily,
                            fontSize = 12.sp,
                            color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(33.dp))

                    Button(onClick = {
                        showDialog = true
                    },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        modifier = Modifier.fillMaxWidth()){
                        Text("Dafter Sekarang",
                            color = buttonfocus,
                            fontSize = 16.sp,
                            fontFamily = localFontFamily,
                            fontWeight = FontWeight.W600)
                    }
                }
            }
        }
    }

    if (showDialog){
        PopUpEvent(
            onDismiss = {showDialog = false}
        )
    }
}