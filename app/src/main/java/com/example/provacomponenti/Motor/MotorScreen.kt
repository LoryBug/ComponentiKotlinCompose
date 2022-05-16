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
import androidx.lifecycle.LiveData
import com.example.provacomponenti.CardNewMoto
import com.example.provacomponenti.CardPosMotor
import com.example.provacomponenti.CommonItem.TopBarSec
import com.example.provacomponenti.Database.AppDatabase
import com.example.provacomponenti.Database.AppRepository
import com.example.provacomponenti.Database.MotorDAO
import com.example.provacomponenti.Database.Motor



@Composable
fun MotorScreen() {
     //val appDatabase by lazy { AppDatabase.getInstance(this).motorDao() }
    Scaffold(topBar = { TopBarSec("Moto") }) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 56.dp)) {

            val repository : AppRepository = AppRepository(motorDAO, tracciatiDAO)
           // val motorDAO

            for (motor in ) {
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
