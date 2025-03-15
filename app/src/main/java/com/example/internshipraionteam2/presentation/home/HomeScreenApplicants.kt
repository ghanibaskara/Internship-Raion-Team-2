package com.example.internshipraionteam2.presentation.home

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.internshipraionteam2.data.ViewModel.AuthState
import com.example.internshipraionteam2.data.ViewModel.AuthViewModel
import com.example.internshipraionteam2.data.network.SharedViewModel
import com.example.internshipraionteam2.presentation.navigation.NavItem
import com.example.internshipraionteam2.reusable.buttonfocus
import com.example.internshipraionteam2.supabase.SupabaseClient
import com.example.internshipraionteam2.supabase.SupabaseViewModel
import com.example.internshipraionteam2.supabase.utils.uriToByteArray
import io.github.jan.supabase.BuildConfig

@Composable
fun HomeScreenApplicants(
    navController: NavController, authViewModel: AuthViewModel, supabaseViewModel: SupabaseViewModel
) {
    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Notification", Icons.Default.Notifications),
        NavItem("Sttings", Icons.Default.Settings)
    )

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    var context = LocalContext.current

    val authState = authViewModel.authState.observeAsState()

    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? -> imageUri = uri }

    var imageUrl by remember {
        mutableStateOf("")
    }

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("UserOption")
            else -> Unit
        }
    }


    Scaffold(bottomBar = {
        NavigationBar {
            navItemList.forEachIndexed { index, navItem ->
                NavigationBarItem(selected = selectedIndex == index, onClick = {
                    selectedIndex = index
                }, icon = {
                    Icon(imageVector = navItem.icon, contentDescription = "Icon")
                }, label = {
                    Text(text = navItem.label)
                })
            }
        }
    }, content = { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { authViewModel.signout() }) { }

            Button(onClick = { supabaseViewModel.createBucket("photos") }) {
                Text("Create Bucket")
            }

            Button(onClick = { launcher.launch("image/*") }) {
                Text("Select Image")
            }

            if (imageUri != null) {
                Button(onClick = {
                    val imageByteArray = imageUri?.uriToByteArray(context)
                    imageByteArray?.let {
                        supabaseViewModel.uploadFIle("photos", "newImage", it)
                    }
                }) {
                    Text("Upload Image")
                }
            }

            Button(onClick = {
                supabaseViewModel.readFile("photos", "newImage") {
                    imageUrl = "${SupabaseClient.client.supabaseUrl}/storage/v1/$it"
                }
            }) {
                Text("Preview Image")
            }

            Text(text = if (imageUri != null) "Image is Selected" else "")

            if (imageUrl.isNotEmpty()){
                AsyncImage(imageUrl, "")
            }
        }
    })
}