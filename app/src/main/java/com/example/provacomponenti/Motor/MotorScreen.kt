package com.example.provacomponenti.Motor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.CardNewMoto
import com.example.provacomponenti.CommonItem.TopBarSec
import com.example.provacomponenti.Motor.Card.CardAddMoto


@Composable
fun MotorScreen() {

    Scaffold(topBar = { TopBarSec("Moto") }) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp), horizontalAlignment = Alignment.CenterHorizontally) {

           // val motorDAO


            /*for (motor in ) {
                item { CardPosMotor(motor) }
            }*/
            item { Spacer(modifier = Modifier.height(12.dp))}
            item{
                CardAddMoto()
            }
            item { Spacer(modifier = Modifier.height(6.dp)) }

        }
    }
}
