package com.example.provacomponenti.Motor

import TopBarMotor
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Model.motors
import com.example.provacomponenti.MotorsCard

@Composable
fun MotorScreen(){
        MotorsCard(motors)
}