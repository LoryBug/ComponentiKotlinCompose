package com.example.provacomponenti

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.Database.Motor


/*fun MotorsCard(motors: List<Motor> = listOf()) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        for (motor in motors) {
            //item { CardPos(name = toStringMotor(motor)) }
            item { motor.model?.let { CardPos(name = it) } }

        }
    }
}*/
//---------------------------------Creazione delle card----------------------------------------------//
@Composable
fun CardPosMotor(motor: Motor) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        ExpCardMotor(motor)
    }
}
//----------------------------------Contenuto card espandibili---------------------------------------//
@Composable
private fun ExpCardMotor(motor: Motor) {

    var expanded by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp
    )
    Row(
        modifier = Modifier
            .padding(24.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))

        ) {
            motor.model?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold
                )
            }
            if (expanded) {
                Column {
                    motor.brand?.let { Text("$it") }
                    motor.displacement?.let { Text("Cilindrata: $it") }
                    motor.hp?.let { Text("$it Hp") }
                    motor.kg?.let { Text("$it Kg") }
                    motor.typeOfMoto?.let { Text("$it") }
                    /*motor.typeOfMoto?.let { Text("$it") }
                    motor.typeOfMoto?.let { Text("$it") }*/


                }

            }
        }
        OutlinedButton(
            onClick = { expanded = !expanded }
        ) {
            Text(if (expanded) "Show less" else "Show more")
        }
    }
}


