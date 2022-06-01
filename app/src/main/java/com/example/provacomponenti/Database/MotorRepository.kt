package com.example.provacomponenti.Database

import javax.inject.Inject


class MotorRepository @Inject constructor(private val motorDAO: MotorDAO) {


    suspend fun addMoto(newMotor: Motor) {
        motorDAO.insertMoto(newMotor)
    }
    suspend fun getAllMotors(): List<Motor> {
        return motorDAO.getMotors()
    }/*
    suspend fun getExpInsMoto(): String?{
        return motorDAO.getExpiringInsuranceMoto()
    }
    suspend fun getExpTaxMoto(): String? {
        return motorDAO.getExpiringTaxMoto()
    }*/
}

