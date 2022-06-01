package com.example.provacomponenti

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.provacomponenti.Database.Motor

//---------------------------------Creazione delle card----------------------------------------------//
@Composable
fun CardPosMotor(motor: Motor) {
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = 4.dp
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
                    Spacer(modifier = Modifier.height(12.dp))
                    AsyncImage(
                        modifier = Modifier.clip(RoundedCornerShape(5.dp)),
                        model = motor.imageURL,
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                    )
                    motor.brand?.let { Text("Marca: $it") }
                    motor.displacement?.let { Text("Cilindrata: $it") }
                    motor.hp?.let { Text("Potenza: $it Hp") }
                    motor.kg?.let { Text("Peso: $it Kg") }
                    motor.typeOfMoto?.let { Text(it) }
                    motor.insuranceExpire?.let { Text("Assicurazione: $it") }
                    motor.taxExpire?.let { Text("Bollo: $it") }
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


