package com.example.provacomponenti.Prova.DataBaseProva

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.provacomponenti.Database.Motor
import com.example.provacomponenti.Database.MotorDAO
import com.example.provacomponenti.Database.Track
import com.example.provacomponenti.Database.TrackDAO

class RepositoryProva(application: Application){
    private var motorDao : MotorDAO
    private var trackDao : TrackDAO

    init {
        val database = DatabaseProva.getDB(application)
        motorDao = database.motorDao()
        trackDao = database.trackDao()
    }

    //-------------------Moto-----------------------------------

    val readAllMoto:LiveData<List<Motor>> = motorDao.getMotors()
    suspend fun insertMoto(motor: Motor){
        motorDao.insertMoto(motor)
    }




    //------------------Track-------------------------

    val readAllTrack :LiveData<List<Track>> = trackDao.getTrack()
    suspend fun  insertTrack(track: Track){
        trackDao.insertTrack(track)
    }

    init {
        val database = DatabaseProva.getDB(application)
        motorDao = database.motorDao()
        trackDao = database.trackDao()
    }

}