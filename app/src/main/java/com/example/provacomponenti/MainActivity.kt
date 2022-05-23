package com.example.provacomponenti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.CommonItem.DefaultSnackBar
import com.example.provacomponenti.CommonItem.FabMaps
import com.example.provacomponenti.CommonItem.FloatingActionButtons
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Login.Login
import com.example.provacomponenti.Navigation.Navigation
import com.example.provacomponenti.Permission.EnablePermissionUI
import com.example.provacomponenti.Permission.Sample
import com.example.provacomponenti.ui.theme.ProvaComponentiTheme
import com.example.provacomponenti.viewModel.PermissionViewModel


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
                //MainScreen()
                Login {

                }
                //ProvaTrackScreen()



            }
        }
    }
}


@Composable
fun MainScreen(
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = { FloatingActionButtons(navController) },
    ) {
        Navigation(navController = navController)
    }
}
/*
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
/*
class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val provaViewModel = ViewModelProvider(this)[ViewModelProva::class.java]
        setContent {
            ProvaComponentiTheme {
                MotorList(provaViewModel)
            }
        }
    }
}

 */*/
