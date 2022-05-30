package com.example.provacomponenti.Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject


class MotorRepository @Inject constructor(private val motorDAO: MotorDAO) {


    suspend fun addMoto(newMotor: Motor) {
        motorDAO.insertMoto(newMotor)
    }

    suspend fun getAllMotors(): List<Motor> {
        return motorDAO.getMotors()
    }
}

