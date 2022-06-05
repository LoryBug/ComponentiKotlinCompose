package com.example.provacomponenti.camera

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.provacomponenti.R

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import java.io.File
import java.security.Timestamp

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(navController: NavController) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }
    var preview by remember { mutableStateOf<Preview?>(null) }
    val executor = ContextCompat.getMainExecutor(context)
    val cameraProvider = cameraProviderFuture.get()
    var camera = cameraProvider.bindToLifecycle(lifecycleOwner, CameraSelector.DEFAULT_BACK_CAMERA)
    var photoFile = File(
        context.getDirectory(),
        "moto.png"
    )
    var onMediaCaptured = { uri: Uri -> Unit }

//TExt field inserire nome moto per usarlo come salvataggio
    Scaffold(topBar = { TopBarCamera(navController) })
    {
        val photoUri = Uri.fromFile(photoFile)
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        Column() {


            Button(onClick = {
                val imgCapture = imageCapture ?: return@Button

                imgCapture.takePicture(
                    outputOptions,
                    executor,
                    object : ImageCapture.OnImageSavedCallback {
                        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                            onMediaCaptured(photoUri)
                            Toast.makeText(context, "Image scanned", Toast.LENGTH_SHORT).show()
                        }

                        override fun onError(exception: ImageCaptureException) {
                            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                )
            }) {
                Text(text = "foto")
            }
            Text("$photoUri")

            AndroidView(
                modifier = Modifier.fillMaxSize(0.90f),
                factory = { ctx ->
                    val previewView = PreviewView(ctx)
                    cameraProviderFuture.addListener({
                        imageCapture = ImageCapture.Builder()
                            .setTargetRotation(previewView.display.rotation)
                            .build()

                        val cameraSelector = CameraSelector.Builder()
                            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                            .build()

                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner,
                            cameraSelector,
                            imageCapture,
                            preview
                        )
                    }, executor)
                    preview = Preview.Builder().build().also {
                        it.setSurfaceProvider(previewView.surfaceProvider)
                    }
                    previewView
                }
            )
        }

        /*
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
    }*/

    }
}


//Store the capture image
fun Context.getDirectory(): File {
    val mediaDir = this.externalMediaDirs.firstOrNull()?.let {
        File(it, this.resources.getString(R.string.app_name)).apply { mkdirs() }
    }
    return if (mediaDir != null && mediaDir.exists())
        mediaDir else this.filesDir
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

fun GetImageUrl(): String? {
    var image: String? = null

    return image
}

