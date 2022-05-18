package com.example.provacomponenti.Prova.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.CommonItem.TopBarSec

@Composable
fun ProvaTrackScreen() {
    var barState by rememberSaveable{(mutableStateOf(false))}


    Scaffold(
        topBar = { TopBarSec("Tracciati") },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "image",
                    tint = Color.White
                )
            }
        },
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    color = Color.LightGray
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text("MyTracks")
                        Text("Scaricabili")
                    }
                }
            }
        }
    )
}