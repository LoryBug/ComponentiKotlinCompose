package com.example.provacomponenti.Database



sealed class MotorEvent{
    data class AddMoto(val motor: Motor) : MotorEvent()
    object GetAllMoto : MotorEvent()
}
