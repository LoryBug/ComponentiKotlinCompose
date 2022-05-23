package com.example.provacomponenti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.CommonItem.FloatingActionButtons
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Login.Login
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
                MainScreen()



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
