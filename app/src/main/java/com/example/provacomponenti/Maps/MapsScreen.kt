package com.example.provacomponenti.Maps

import android.location.Location
import android.os.Bundle
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.CommonItem.FabMaps
import com.example.provacomponenti.CommonItem.TopBarSec
import com.example.provacomponenti.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.google.maps.android.compose.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun MapsScreen() {

    val context = LocalContext.current

    var isMapLoaded by remember {
        mutableStateOf(false)
    }
    val forli = LatLng(44.233334, 12.050000)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(forli, 11f)
    }

    Scaffold(
        topBar = { TopBarSec("Punti di ritrovo") },
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            GoogleMapView(modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded =true
            },)
            if (!isMapLoaded){
                AnimatedVisibility(
                    modifier = Modifier
                        .matchParentSize(),
                    visible = !isMapLoaded,
                    enter = EnterTransition.None,
                    exit = fadeOut()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                            .wrapContentSize()
                    )}

            }
        }


        Spacer(modifier = Modifier.height(36.dp))
    }
}

@Composable
fun GoogleMapView(
    modifier: Modifier,
    cameraPositionState: CameraPositionState,
    onMapLoaded: ()->Unit,
    content: @Composable ()-> Unit = {}
){
    var mapProperties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }
    var mapVisible by remember {
        mutableStateOf(true)
    }
    var uiSettings by remember { mutableStateOf(MapUiSettings(compassEnabled = false)) }

    if (mapVisible){
        GoogleMap(modifier = modifier,
        cameraPositionState = cameraPositionState,
        properties = mapProperties,
            uiSettings = uiSettings,
            onMapLoaded = onMapLoaded,
            onPOIClick = {

            }
        )
        {
            Marker(
                state = MarkerState(position = LatLng(44.20306363601473, 12.04606243599329)),
                title = "Big Bar"

            )
            Marker(
                state = MarkerState(position = LatLng(44.09056599689349, 11.979212269509826)),
                title = "Predappio"
            )
        }

    }

}
/*
@Composable
fun GoogleMap(
) {

    val forli = LatLng(44.233334, 12.050000)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(forli, 11f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ){
            Marker(
                state = MarkerState(position = LatLng(44.20306363601473, 12.04606243599329)),
                title = "Big Bar"

            )
            Marker(
                state = MarkerState(position = LatLng(44.09056599689349, 11.979212269509826)),
                title = "Predappio"
            )
        }
    }
}*/