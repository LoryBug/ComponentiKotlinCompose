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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.CommonItem.DefaultSnackBar
import com.example.provacomponenti.CommonItem.FabMaps
import com.example.provacomponenti.CommonItem.FloatingActionButtons
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Navigation.Navigation
import com.example.provacomponenti.Permission.EnablePermissionUI
import com.example.provacomponenti.Prova.DataBaseProva.MotorList
import com.example.provacomponenti.Prova.DataBaseProva.ViewModelProva
import com.example.provacomponenti.Prova.Screen.ProvaTrackScreen
import com.example.provacomponenti.ui.theme.ProvaComponentiTheme
import com.example.provacomponenti.viewModel.PermissionViewModel


class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()
            val permissionViewModel = PermissionViewModel()

            ProvaComponentiTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Location Permission",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        },
                        scaffoldState = scaffoldState,
                        snackbarHost = { scaffoldState.snackbarHostState },
                        content = { innerPadding ->
                            Column {
                                Box(modifier = Modifier.padding(innerPadding)) {
                                    EnablePermissionUI(
                                        scaffoldState = scaffoldState,
                                        permissionViewModel = permissionViewModel
                                    )

                                    DefaultSnackBar(
                                        snackbarHostState = scaffoldState.snackbarHostState,
                                        modifier = Modifier.align(Alignment.BottomCenter),
                                        onAction = {
                                            scaffoldState.snackbarHostState.currentSnackbarData?.performAction()
                                        }
                                    )
                                }
                            }
                        }
                    )
                }
                // A surface container using the 'background' color from the theme
                //CardNewMoto()
                //Greetings(motors)
                //TrackCard(tracks)
                //HomeScreen()
                //MotorScreen()
                //MainScreen()
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
