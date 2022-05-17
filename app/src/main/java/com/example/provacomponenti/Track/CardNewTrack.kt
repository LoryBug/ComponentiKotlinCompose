package com.example.provacomponenti.Track

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp



@Composable
fun CardNewTrack(){
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        ExpCardNewTrack()
    }
}

@Composable
private fun ExpCardNewTrack(){
    var expanded by rememberSaveable { mutableStateOf(false) }
    var id by remember { mutableStateOf(TextFieldValue("")) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp
    )
    Row(modifier = Modifier.padding(24.dp)
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
        ) {
            Text(
                text = "Nuova traccia",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.SemiBold
            )
            if (expanded) {
                Text(
                    "Inserire nuova traccia",

                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = id,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    label = { Text("Id", color = Color.LightGray) },
                    placeholder = { Text(text = "Id") },
                    onValueChange = {
                        id = it
                    },

                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedButton(
                    onClick = { }
                ) {
                    Text("Aggiungi")
                }
                Spacer(modifier = Modifier.height(12.dp))

            }
        }
        OutlinedButton(
            onClick = { expanded = !expanded }
        ) {
            Text(if (expanded) "-" else "+")
        }
    }
}