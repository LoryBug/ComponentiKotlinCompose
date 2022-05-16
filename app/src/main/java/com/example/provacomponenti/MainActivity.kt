package com.example.provacomponenti

import android.os.Bundle
import android.app.Application
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.CommonItem.FloatingActionButtons
import com.example.provacomponenti.Database.Motor
import com.example.provacomponenti.Database.Track
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Navigation.Navigation
import com.example.provacomponenti.ui.theme.ProvaComponentiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvaComponentiTheme {
                // A surface container using the 'background' color from the theme
                //CardNewMoto()
                //Greetings(motors)
                //TrackCard(tracks)
                //HomeScreen()
                //MotorScreen()
                ScreenSetup()

            }
        }
    }
}

@Composable
fun MainScreen(
    allMotor: List<Motor>,
    allTrack: List<Track>,
    viewModel: MainViewModel
) {
    val navController = rememberNavController()




    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = { FloatingActionButtons(navController) },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Navigation(navController = navController)
    }
}

@Composable
fun ScreenSetup(
    viewModel: MainViewModel
    = MainViewModel(LocalContext.current.applicationContext as Application)
) {

    val allMotor by viewModel.allMotors.observeAsState(listOf())
    val allTrack by viewModel.allTrack.observeAsState(listOf())
    MainScreen(
        allMotor = allMotor,
        allTrack = allTrack,
        viewModel = viewModel
    )
}

