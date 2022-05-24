package com.example.provacomponenti.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.provacomponenti.Home.HomeScreen
import com.example.provacomponenti.Login.Login
import com.example.provacomponenti.Maps.MapsScreen
import com.example.provacomponenti.Motor.MotorScreen
import com.example.provacomponenti.Permission.Sample
import com.example.provacomponenti.Track.TrackScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.MyMotors.route) {
            MotorScreen(navController)
        }
        composable(NavigationItem.MyTracks.route) {
            TrackScreen(navController)
        }
       /* composable(NavigationItem.Permission.route){
            Sample(navController)
        }*/
        composable(NavigationItem.Maps.route){
            MapsScreen(navController)
        }
    }
}