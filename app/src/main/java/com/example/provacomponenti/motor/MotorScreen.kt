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
import com.example.provacomponenti.commonItem.FabMaps


import com.example.provacomponenti.motor.Card.CardAddMoto


@Composable
fun MotorScreen(
    navController: NavController, motorViewModel: MotorViewModel
) {

    Scaffold(topBar = { TopBarSec("Moto", navController)
    }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item { Spacer(modifier = Modifier.height(12.dp)) }
            items(motorViewModel.allMotor) {
                CardPosMotor(motor = it)
            }
            item {
                CardAddMoto(motorViewModel,navController)
            }
            item { Spacer(modifier = Modifier.height(6.dp)) }
        }
    }
}


