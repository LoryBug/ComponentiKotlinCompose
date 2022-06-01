package com.example.provacomponenti.Database

sealed class TrackEvent{
    data class AddTrack(val track: Track) : TrackEvent()
    object GetAllTrack : TrackEvent()
    object GetLatestTrack : TrackEvent()

}
