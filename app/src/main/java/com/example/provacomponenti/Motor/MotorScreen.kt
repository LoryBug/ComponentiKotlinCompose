package com.example.provacomponenti.Motor

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.CardPosMotor
import com.example.provacomponenti.CommonItem.TopBarSec
import com.example.provacomponenti.viewModel.MainViewModel
import com.example.provacomponenti.Motor.Card.CardAddMoto


@Composable
fun MotorScreen(
) {
    
    Scaffold(topBar = { TopBarSec("Moto") }) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp), horizontalAlignment = Alignment.CenterHorizontally) {


            item { Spacer(modifier = Modifier.height(12.dp))}
            item{
                CardAddMoto()
            }
            item { Spacer(modifier = Modifier.height(6.dp)) }

        }
    }
}

@Composable
fun MotorScreenSetup(
    viewModel: MainViewModel = MainViewModel(LocalContext.current.applicationContext as Application)
){
    val allMotor by viewModel.allMotors.observeAsState(listOf())

    for (motor in allMotor) {
        CardPosMotor(motor)
    }
}
