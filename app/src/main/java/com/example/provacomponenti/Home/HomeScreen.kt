package com.example.provacomponenti.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Home.TopBar.TopBar
import com.example.provacomponenti.Model.tracks
import com.example.provacomponenti.R
import com.example.provacomponenti.TrackCard

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = MaterialTheme.colors.secondary,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)

            ) {
                Icon(painterResource(id = R.drawable.ic_pin), "pin")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = {
            Surface() {
                Column() {
                     Text(text = "ciao")
                }
            }
        }
    )

}


