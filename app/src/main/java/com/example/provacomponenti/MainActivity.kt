package com.example.provacomponenti

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.home.bottomBar.BottomNavigationBar
import com.example.provacomponenti.login.Login
import com.example.provacomponenti.navigation.Navigation
import com.example.provacomponenti.ui.theme.ProvaComponentiTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint


var userLocLongitude: Double? = null
var userLocLatitude: Double? = null


private lateinit var fusedLocationClient: FusedLocationProviderClient

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->

                userLocLongitude = location?.longitude

                userLocLatitude = location?.latitude

            }
        setContent {
            ProvaComponentiTheme {
                LoginScreen()
            }
        }
    }
}

var showMainScreen by mutableStateOf(false)

@Composable
fun LoginScreen() {
    Login {
        showMainScreen = true
    }
    if (showMainScreen) {
        MainScreen()
    }
}

@Composable
fun MainScreen(
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },

    ) {
        Navigation(navController = navController)
    }


}
