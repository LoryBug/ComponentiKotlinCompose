package com.example.provacomponenti.Database

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class MotorViewModel
@Inject
constructor(
    motorDAO: MotorDAO
) : ViewModel() {
     val allMotor = mutableListOf<Motor>()

    private val repository: MotorRepository = MotorRepository(motorDAO)


    var powerMoto: String? = null
    var powerMotoModel: String? = null
    var insuranceMotor: String? = null
    var insuranceDate: String? = null
    var taxMotor : String? = null
    var taxDate : String? = null
    var motor: Motor? = null

        private set
    init {
        onTriggerEvent(MotorEvent.GetAllMoto)
    }
    fun onTriggerEvent(event: MotorEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (event) {
                    is MotorEvent.AddMoto -> {
                        addMoto(event.motor)
                    }
                    is MotorEvent.GetAllMoto -> {
                        allMotor.addAll(repository.getAllMotors())
                    }
                    is MotorEvent.GetExpiringInsMoto -> {
                        getExpInsMoto()
                    }
                    is MotorEvent.GetExpiringTaxMoto -> {
                        getExpTaxMoto()
                    }
                    is MotorEvent.GetPowerMoto ->{
                        getPowerMoto()
                    }
                }
            } catch (e : Exception){
                Log.e("Errore",e.message.toString())
            }
        }
    }
    private suspend fun addMoto(motor: Motor) {
        repository.addMoto(motor)
        allMotor.add(motor)
    }
    private suspend fun getExpInsMoto() {
        insuranceMotor =  repository.getAllMotors().minByOrNull {
            it.insuranceExpire!!
        }!!.model
        insuranceDate =  repository.getAllMotors().minByOrNull {
            it.insuranceExpire!!
        }?.insuranceExpire
    }
    private suspend fun getExpTaxMoto(){

        taxMotor = repository.getAllMotors().maxByOrNull {
            it.taxExpire!!
        }?.model
        taxDate = repository.getAllMotors().maxByOrNull {
            it.taxExpire!!
        }?.taxExpire
    }

    private suspend fun getPowerMoto(){
        powerMoto = repository.getAllMotors().minByOrNull {it.hp!! }?.hp
        powerMotoModel = repository.getAllMotors().minByOrNull { it.hp!! }?.model

    }
}
