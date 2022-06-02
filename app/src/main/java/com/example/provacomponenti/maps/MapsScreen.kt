package com.example.provacomponenti.maps

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.provacomponenti.commonItem.TopBarSec
import com.example.provacomponenti.Database.favPlaceList
import com.example.provacomponenti.commonItem.FabMaps
import com.example.provacomponenti.home.bottomBar.BottomNavigationBar
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*



@Composable
fun MapsScreen(navController: NavController) {

    var isMapLoaded by remember {
        mutableStateOf(false)
    }

    val cesena = LatLng(44.14837871007344, 12.235793867040725)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(cesena, 14f)
    }
    Scaffold(
        topBar = { TopBarSec("Punti di ritrovo",navController)},


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

            },
        )
        {
            for(marker in favPlaceList){
                Marker(
                    state = MarkerState(position = LatLng(marker.lat,marker.lon)),
                    title = marker.title
                )
            }
            Marker(
                state = MarkerState(position = LatLng(44.14837871007344, 12.235793867040725)),
                title = "La mia posizione"

            )
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