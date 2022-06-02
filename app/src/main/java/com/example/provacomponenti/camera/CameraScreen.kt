package com.example.provacomponenti.camera

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.provacomponenti.commonItem.TopBarSec

@Composable
fun CameraScreen(navController: NavController){
    Scaffold(topBar = { TopBarCamera(navController) }) {
        CameraPreview()
    }

}

@Composable
fun TopBarCamera(navController: NavController){
    TopAppBar(
        title = { Text("Camera", color = MaterialTheme.colors.onPrimary) },
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        })

}
