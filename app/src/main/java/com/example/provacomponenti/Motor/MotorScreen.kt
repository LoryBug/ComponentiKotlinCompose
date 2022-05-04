package com.example.provacomponenti.Motor

import TopBarMotor
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.provacomponenti.Model.motors
import com.example.provacomponenti.MotorsCard

@Composable
fun MotorScreen() {
    Scaffold(topBar = { TopBarMotor() }) {
        MotorsCard(motors)
    }
}
