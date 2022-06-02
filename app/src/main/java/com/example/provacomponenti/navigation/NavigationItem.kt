package com.example.provacomponenti.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import com.example.provacomponenti.R


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object MyMotors : NavigationItem("motor", R.drawable.ic_two_wheeler, "Motors")
    object MyTracks : NavigationItem("track", R.drawable.ic_track, "Tracks")
    object Maps : NavigationItem("maps", R.drawable.ic_pin, "Maps")
    object Camera : NavigationItem("camera", R.drawable.ic_home, "Camera")
}
