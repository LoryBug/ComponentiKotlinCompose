package com.example.provacomponenti.Prova.DataBaseProva

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.provacomponenti.Database.Motor

@Composable
fun MotorList(prova: ViewModelProva){

    val motorList = prova.getAllMotors().observeAsState(arrayListOf())
    
    Scaffold(modifier = Modifier.fillMaxSize(),

    floatingActionButton ={
        ExtendedFloatingActionButton(
            backgroundColor = Color.Red,
            text = {
                Text(text = "Moto", color = Color.White)
            },
            onClick = {
                prova.insertMotor(
                    Motor(
                        0,"Honda","FMX","650","SuperMotard",
                        15,  0,0,21002,"vaio"
                    )
                )
            }, icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "image",
                    tint = Color.White
                )

            }
                )
            }
    ) {
        LazyColumn(){
            items(
                items = motorList.value, itemContent = {
                    for (motor in motorList.value){
                        Text(motor.model?:"")

                    }

                }
            )
        }

    }
}