package com.example.provacomponenti.Profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.provacomponenti.CardNewMoto

@Composable
fun ProfileScreen() {
    Scaffold(topBar = { TopBarProfile()}) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CardNewMoto()
        }

        
    }
}