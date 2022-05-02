package com.example.provacomponenti

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.Model.Motor
import com.example.provacomponenti.Model.Track
import com.example.provacomponenti.Model.motors
import com.example.provacomponenti.Model.tracks
import com.example.provacomponenti.ui.theme.ProvaComponentiTheme

@Composable
fun TrackCard(tracks: List<Track> = listOf()) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        for (track in tracks) {
            item { track.name?.let { ExpCard(name = it) }}
        }
    }
}

@Composable
private fun ExpCard(name: String) {

    var expanded by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )


    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 4.dp,
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = name, style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.SemiBold)
                if (expanded){
                    Text(
                        "${tracks.listIterator().next().name}")
                   /* Text(
                        "Cilindrata:"+"${motors.listIterator().next().displacement}")
                    Text(
                        "Cavalli:"+"${motors.listIterator().next().hp}")
                    Text(
                        "Genere"+"${motors.listIterator().next().typeOfMoto}")*/

                }

            }
            OutlinedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ProvaComponentiTheme {

        TrackCard(tracks)
    }
}
