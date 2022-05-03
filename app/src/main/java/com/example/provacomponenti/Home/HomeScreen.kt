package com.example.provacomponenti.Home

import android.content.ClipData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.CardNewMoto
import com.example.provacomponenti.Greetings
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Home.TopBar.TopBar
import com.example.provacomponenti.Model.insertNewMoto
import com.example.provacomponenti.Model.motors
import com.example.provacomponenti.Model.tracks
import com.example.provacomponenti.R
import com.example.provacomponenti.TrackCard

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar() },
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
                     TrackCard(tracks)
                }
            }
        }
    )

}


