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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun CardNewTrack() {
    Card(
        backgroundColor = Color.LightGray,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        ExpCardNewTrack()
    }
}

@Composable
private fun ExpCardNewTrack() {

    var id by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var km by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var typoOfTrack by remember { mutableStateOf(TextFieldValue("")) }
    var diff by remember { mutableStateOf(TextFieldValue("")) }
    // var image by remember { mutableStateOf(TextFieldValue("")) }

    var expanded by rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Nuova traccia",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(12.dp))
        if (expanded) {
            Text(
                "Inserire nuova traccia",

                )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = name,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Nome", color = Color.Black) },
                placeholder = { Text(text = "Nome") },
                onValueChange = {
                    name = it
                },

                )
            OutlinedTextField(
                value = km,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Km", color = Color.Black) },
                placeholder = { Text(text = "Km") },
                onValueChange = {
                    km = it
                },

                )
            OutlinedTextField(
                value = description,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Descrizione", color = Color.Black) },
                placeholder = { Text(text = "Descrizione") },
                onValueChange = {
                    description = it
                },

                )
            OutlinedTextField(
                value = typoOfTrack,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Tipo", color = Color.Black) },
                placeholder = { Text(text = "Tipo") },
                onValueChange = {
                    typoOfTrack = it
                },

                )
            OutlinedTextField(
                value = diff,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Difficoltà", color = Color.Black) },
                placeholder = { Text(text = "Difficoltà") },
                onValueChange = {
                    diff = it
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
        OutlinedButton(
            onClick = { expanded = !expanded }
        ) {
            Text(if (expanded) "-" else "+")
        }
        Spacer(modifier = Modifier.height(12.dp))
    }

}

