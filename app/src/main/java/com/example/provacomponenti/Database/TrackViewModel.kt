package com.example.provacomponenti.Database

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class TrackViewModel
@Inject
constructor(
    trackDAO: TrackDAO
) : ViewModel() {
    val allTrack = mutableListOf<Track>()

    var lastTrack: String? = null

    var shortestTrack : String? = null

    private val repository: TrackRepository

    var track: Track? = null
        private set

    init {

        repository = TrackRepository(trackDAO)
        onTriggerEvent(TrackEvent.GetAllTrack)
    }

    fun onTriggerEvent(event: TrackEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (event) {
                    is TrackEvent.AddTrack -> {
                        addTrack(event.track)
                    }
                    is TrackEvent.GetAllTrack -> {
                        allTrack.addAll(repository.getAllTrack())
                    }
                }

            } catch (e : Exception){
                Log.e("Errore",e.message.toString())
            }
        }

    }

    private suspend fun addTrack(track: Track) {
        repository.addTrack(track)
        allTrack.add(track)
    }

    private suspend fun getLatestTrack(){
        lastTrack = repository.getAllTrack().minByOrNull {
            it.name!!
        }?.name
    }
    private suspend fun  getShortestTrack(){
        shortestTrack = repository.getAllTrack().minByOrNull { it.km!! }?.name
    }

}
