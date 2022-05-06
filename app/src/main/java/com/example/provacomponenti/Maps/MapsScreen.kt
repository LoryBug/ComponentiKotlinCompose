package com.example.provacomponenti.Maps

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.provacomponenti.CommonItem.TopBarSec

@Composable
fun MapsScreen(){
    Scaffold(
        topBar = { TopBarSec("Punti di ritrovo") }
    ) {
        Text(text = "MAPPA")
    }
}