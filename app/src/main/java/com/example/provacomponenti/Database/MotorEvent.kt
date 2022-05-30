package com.example.provacomponenti.Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

sealed class MotorEvent{
    data class AddMoto(val motor: Motor) : MotorEvent()
    object GetAllMoto : MotorEvent()
}
