package com.example.provacomponenti.Motor

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.CardNewMoto
import com.example.provacomponenti.CardPosMotor
import com.example.provacomponenti.CommonItem.TopBarSec
import com.example.provacomponenti.Model.motors


@Composable
fun MotorScreen() {
    Scaffold(topBar = { TopBarSec("Moto") }) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 56.dp)) {
            for (motor in motors) {
                item { CardPosMotor(motor) }
            }
            item { Spacer(modifier = Modifier.height(12.dp))}
            item{
                CardNewMoto()
            }
            item { Spacer(modifier = Modifier.height(6.dp)) }

        }
    }
}
