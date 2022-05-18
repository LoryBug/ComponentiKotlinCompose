package com.example.provacomponenti.Track

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.provacomponenti.CardPosTracks
import com.example.provacomponenti.CommonItem.TopBarSec
import com.example.provacomponenti.Database.AppRepository
import com.example.provacomponenti.Database.Track


@Composable
fun TrackScreen(){
    var stato by rememberSaveable { mutableStateOf(true) }
    var trackList : LiveData<List<Track>>
    
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
            if(stato){
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