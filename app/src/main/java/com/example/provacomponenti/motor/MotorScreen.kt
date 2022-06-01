package com.example.provacomponenti.motor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.provacomponenti.CardPosMotor
import com.example.provacomponenti.commonItem.TopBarSec
import com.example.provacomponenti.Database.*


import com.example.provacomponenti.motor.Card.CardAddMoto


@Composable
fun MotorScreen(
    navController: NavController, motorViewModel: MotorViewModel
) {

    Scaffold(topBar = { TopBarSec("Moto", navController) }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item { Spacer(modifier = Modifier.height(12.dp)) }
           item {
                Button(onClick = { AddMotoretta(motorViewModel) }) {
                    Text(text = "ciao")
                }
            }
            items(motorViewModel.allMotor) {
                CardPosMotor(motor = it)
            }
           /*
            for (motor in motors) {
                item { CardPosMotor(motor) }
            }*/
            item {
                CardAddMoto(motorViewModel)
            }
            item { Spacer(modifier = Modifier.height(6.dp)) }
        }
    }
}

fun AddMotoretta(motorViewModel: MotorViewModel) {
    val moto = Motor(
        "1","Honda", "Dominator","650cc","Dual","40","160","180923","301022","https://cdn.inmoto.it/images/2021/02/19/181747538-f1c92825-4e21-4c33-bc17-a86c928c8988.jpg"
    )
    motorViewModel.onTriggerEvent(MotorEvent.AddMoto(moto))
}
