package com.example.provacomponenti.Track

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.provacomponenti.CardPosTracks
import com.example.provacomponenti.CommonItem.TopBarSec
import com.example.provacomponenti.Model.toStringTrack
import com.example.provacomponenti.Model.tracks
import com.example.provacomponenti.TrackCard

@Composable
fun TrackScreen(){
    Scaffold (
        topBar = { TopBarSec("Tracciati") }
            ){
        LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 60.dp)){
            for(track in tracks) {
                item { CardPosTracks(name = toStringTrack(track)) }
                item { Spacer(modifier = Modifier.height(12.dp)) }
            }
            item { CardNewTrack() }
        }

    }
}