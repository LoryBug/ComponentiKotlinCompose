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



@Composable
fun TrackScreen(){
    Scaffold (
        topBar = { TopBarSec("Tracciati") }
            ){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)){
            /*for(track in tracks) {
                item { track.name?.let { CardPosTracks(track) } }
                item { Spacer(modifier = Modifier.height(12.dp)) }
            }*/
            item { CardNewTrack() }
            item { Spacer(modifier = Modifier.height(6.dp)) }
        }

    }
}