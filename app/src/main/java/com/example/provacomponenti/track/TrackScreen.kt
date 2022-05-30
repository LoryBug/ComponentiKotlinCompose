package com.example.provacomponenti.track

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.provacomponenti.CardPosTracks
import com.example.provacomponenti.commonItem.TopBarSec
import com.example.provacomponenti.Database.Track
import com.example.provacomponenti.Database.tracks


@Composable
fun TrackScreen(navController: NavController){
    var stato by rememberSaveable { mutableStateOf(true) }
    var trackList : LiveData<List<Track>>

    Scaffold (
        topBar = { TopBarSec("Tracciati",navController) },

            ){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)){
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item{
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                    Button(onClick = { stato = true }) {
                        Text("Salvate")
                    }
                    Button(onClick = { stato = false}) {
                        Text("Scaricabili")
                    }

                }
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            if(stato){
                for (track in tracks) {
                    item { track.name?.let { CardPosTracks(track) } }
                    item { Spacer(modifier = Modifier.height(12.dp)) }
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item { CardNewTrack() }
            } else
            {
                item { Spacer(modifier = Modifier.height(12.dp)) }

                item{Text(text = "ciao")}
            }

           // item { CardNewTrack() }
            item { Spacer(modifier = Modifier.height(6.dp)) }
        }

    }
}