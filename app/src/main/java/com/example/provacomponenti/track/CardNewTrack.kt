package com.example.provacomponenti.track

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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.example.provacomponenti.Database.Track
import com.example.provacomponenti.Database.TrackEvent
import com.example.provacomponenti.Database.TrackViewModel


@Composable
fun CardNewTrack(trackViewModel: TrackViewModel) {
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        ExpCardNewTrack(trackViewModel)
    }
}

@Composable
private fun ExpCardNewTrack(trackViewModel: TrackViewModel) {

    var id by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var km by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var typoOfTrack by remember { mutableStateOf(TextFieldValue("")) }
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
                "Inserire nuova traccia"
                )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = id,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Id") },
                placeholder = { Text(text = "Id") },
                onValueChange = {
                    id = it
                },

                )
            OutlinedTextField(
                value = name,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Nome") },
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
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Km") },
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
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Descrizione") },
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
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                label = { Text("Tipo") },
                placeholder = { Text(text = "Tipo") },
                onValueChange = {
                    typoOfTrack = it
                },

                )

            var traccia = Track(id.text,name.text,km.text,description.text,typoOfTrack.text,"")

            Text(traccia.toString())
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedButton(
                onClick = {
                    addNewTrack(trackViewModel,traccia)
                }
            ) {
                Text("Aggiungi",color = MaterialTheme.colors.onSurface)
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
        OutlinedButton(
            onClick = { expanded = !expanded }
        ) {
            Text(if (expanded) "-" else "+", fontSize = 21.sp, color = MaterialTheme.colors.onSurface)
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

fun addNewTrack(trackViewModel: TrackViewModel, track: Track) {
    trackViewModel.onTriggerEvent(TrackEvent.AddTrack(track))
}

