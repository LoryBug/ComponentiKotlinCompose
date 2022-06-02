package com.example.provacomponenti.track

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.provacomponenti.commonItem.TopBarSec
import com.example.provacomponenti.Database.TrackViewModel
import com.example.provacomponenti.Database.tracks


@Composable
fun TrackScreen(navController: NavController, trackViewModel: TrackViewModel){
    var stato by rememberSaveable { mutableStateOf(true) }

    val colorButtonMy = if(!stato)   MaterialTheme.colors.primary else MaterialTheme.colors.primary.copy(alpha = 0.3f)
    val colorButtonDow = if(stato)   MaterialTheme.colors.primary else MaterialTheme.colors.primary.copy(alpha = 0.3f)

    Scaffold (
        topBar = { TopBarSec("Tracciati",navController) },
            ){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)){
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item{
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                    Button(onClick = { stato = true }, colors = ButtonDefaults.buttonColors(backgroundColor = colorButtonMy), modifier = Modifier.padding(2.dp))
                         {
                        Text("Le mie tracce")
                    }
                    Button(onClick = { stato = false}, colors = ButtonDefaults.buttonColors(backgroundColor = colorButtonDow),modifier = Modifier.padding(2.dp)) {
                        Text("Scaricabili")
                    }
                }
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            if(stato){
                items(trackViewModel.allTrack){
                    CardPosTracks(track = it)
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item { CardNewTrack( trackViewModel) }
            } else
            {
                item { Spacer(modifier = Modifier.height(12.dp)) }
                for (track in tracks) {
                    item { track.name?.let { CardPosTracks(track) } }
                    item { Spacer(modifier = Modifier.height(12.dp)) }
                }
            }
            item { Spacer(modifier = Modifier.height(6.dp)) }
        }
    }
}