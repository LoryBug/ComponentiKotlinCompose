package com.example.provacomponenti.camera

import android.net.Uri
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(navController: NavController) {
    Scaffold(topBar = { TopBarCamera(navController) }) {


        val emptyImageUri = Uri.parse("file://dev/null")
        var imageUri by remember { mutableStateOf(emptyImageUri) }
        var string : String? = null
        if (imageUri != emptyImageUri) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = "Captured image"
                )
                string = imageUri.toString()
                Text(string!!)

                Button(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onClick = {
                        imageUri = emptyImageUri
                    }
                ) {
                    Text("Remove image")
                }
            }
        } else {
            Column() {
                CameraCapture(
                    modifier = Modifier.fillMaxWidth(),
                    onImageFile = { file ->
                        imageUri = file.toUri()
                        string = imageUri.toString()
                    })
            }
        }
    }
}

@Composable
fun TopBarCamera(navController: NavController) {
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

