package com.example.provacomponenti.Track

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.provacomponenti.Model.tracks
import com.example.provacomponenti.Track.TopBarTrack.TopBarTrack
import com.example.provacomponenti.TrackCard


@Composable
fun TrackScreen(){
    Scaffold (
        topBar = { TopBarTrack() }
            ){
        TrackCard(tracks)

    }


}