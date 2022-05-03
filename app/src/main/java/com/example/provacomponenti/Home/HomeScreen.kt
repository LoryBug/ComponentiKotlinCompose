package com.example.provacomponenti.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.Greetings
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Home.TopBar.TopBar
import com.example.provacomponenti.Model.motors
import com.example.provacomponenti.R

@Composable
fun HomeScreen(){
    Scaffold(
        bottomBar =  { BottomNavigationBar()},
        topBar = { TopBar()},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)

            ) {
                Icon(painterResource(id = R.drawable.ic_pin),  "pin")
            }
        }
    ) {

            Greetings(motors)

    }


}