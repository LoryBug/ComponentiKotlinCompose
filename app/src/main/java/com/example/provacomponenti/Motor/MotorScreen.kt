package com.example.provacomponenti.Motor

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.provacomponenti.CommonItem.TopBarSec
import com.example.provacomponenti.Model.motors
import com.example.provacomponenti.MotorsCard

@Composable
fun MotorScreen() {
    Scaffold(topBar = { TopBarSec("Moto") }) {
        MotorsCard(motors)
    }
}
