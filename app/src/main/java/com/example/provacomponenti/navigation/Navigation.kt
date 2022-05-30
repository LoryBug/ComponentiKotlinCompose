package com.example.provacomponenti.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.provacomponenti.Database.MotorViewModel
import com.example.provacomponenti.Database.TrackViewModel
import com.example.provacomponenti.home.HomeScreen
import com.example.provacomponenti.maps.MapsScreen
import com.example.provacomponenti.motor.MotorScreen
import com.example.provacomponenti.track.TrackScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.MyMotors.route) {
            val motorViewModel = hiltViewModel<MotorViewModel>()
            MotorScreen(navController,motorViewModel)
        }
        composable(NavigationItem.MyTracks.route) {
            val trackViewModel = hiltViewModel<TrackViewModel>()
            TrackScreen(navController,trackViewModel)
        }
       /* composable(NavigationItem.Permission.route){
            Sample(navController)
        }*/
        composable(NavigationItem.Maps.route){
            MapsScreen(navController)
        }
    }
}