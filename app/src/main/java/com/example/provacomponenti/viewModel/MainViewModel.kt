package com.example.provacomponenti.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Room
import com.example.provacomponenti.Database.AppDatabase
import com.example.provacomponenti.Database.AppRepository
import com.example.provacomponenti.Database.Motor
import com.example.provacomponenti.Database.Track

class MainViewModel(application: Application) {
    val allMotors: LiveData<List<Motor>>
    val allTrack: LiveData<List<Track>>
    private val repository: AppRepository

    init {
        val appDb = AppDatabase.getInstance(application)
        val motorDAO = appDb.motorDao()
        val trackDAO = appDb.trackDao()
        repository = AppRepository(motorDAO, trackDAO)
        allMotors = repository.allMotor
        allTrack = repository.allTrack
    }
    fun insertMotor(motor: Motor){
        repository.insertMotor(motor)
    }
}