package com.example.provacomponenti

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.provacomponenti.Home.BottomBar.NavigationItem
import com.example.provacomponenti.Home.HomeScreen
import com.example.provacomponenti.Motor.MotorScreen
import com.example.provacomponenti.Profile.ProfileScreen
import com.example.provacomponenti.Track.TrackScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.MyMotors.route) {
            MotorScreen()
        }
        composable(NavigationItem.MyTracks.route) {
            TrackScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
    }
}