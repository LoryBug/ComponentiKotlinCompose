package com.example.provacomponenti.Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppRepository(private val motorDAO: MotorDAO, private val tracciatiDAO: TracciatiDAO) {

private val coroutineScope = CoroutineScope(Dispatchers.Main)

// Motor

    val allMotor : MutableLiveData<List<Motor>> = motorDAO.getMotors()


    fun getAllMotors(motors: MutableLiveData<List<Motor>>){
        coroutineScope.launch(Dispatchers.IO) {
            motorDAO.getMotors()
        }
    }

    // Track

    fun getAllTracks(track: Track){
        coroutineScope.launch(Dispatchers.IO) {
            tracciatiDAO.getTracciati()
        }
    }


}