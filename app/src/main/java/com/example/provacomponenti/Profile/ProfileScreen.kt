package com.example.provacomponenti.Profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.CardNewMoto
import com.example.provacomponenti.CommonItem.TopBarSec

@Composable
fun ProfileScreen() {
    Scaffold(topBar = { TopBarSec("Profilo") }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(120.dp))
            Row(modifier = Modifier.fillMaxWidth()) {


            }

        }

        
    }
}