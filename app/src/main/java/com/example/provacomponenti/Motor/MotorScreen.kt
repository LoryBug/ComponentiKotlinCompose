package com.example.provacomponenti.Motor

import TopBarMotor
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.Model.motors
import com.example.provacomponenti.MotorsCard
import com.example.provacomponenti.R

@Composable
fun MotorScreen() {
    Scaffold(topBar = { TopBarMotor() }) {
        MotorsCard(motors)
    }
}
