package com.example.provacomponenti

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.Model.*

/*
@Composable
fun TrackCard(tracks: List<Track> = listOf()) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        for (track in tracks) {
            item { CardPosTracks(name = toStringTrack(track)) }
        }
    }
}*/

// -------------------------------
@Composable
fun CardPosTracks(track: Track) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        ExpCardTrack(track)
    }
}

//---------------------------------
@Composable
private fun ExpCardTrack(track: Track) {

    var expanded by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp
        )
    Row(modifier = Modifier
        .padding(24.dp)
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
            track.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold
                )
            }
            if (expanded) {
                Column() {
                    track.km?.let { Text("$it Km") }
                    track.description?.let { Text(it) }
                    track.typeOfTrack?.let { Text("Tipo di traccia: $it")}
                    track.difficulty?.let { Text("Difficoltà: $it")}
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




