package com.example.provacomponenti.Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MotorDAO{
    //----------------------------------    MOTO    ------------------------------------//

    @Insert(onConflict = OnConflictStrategy.IGNORE) //  INSERIMENTO MOTO
    suspend fun insertMoto(motor: Motor)

    @Query("SELECT * FROM Motor")
    suspend fun getMotors() : List<Motor>

    @Query("SELECT * FROM Motor ORDER BY insuranceExpire DESC LIMIT(1)")
    suspend fun getExpiringInsuranceMoto() : Motor

    @Query("SELECT * FROM Motor ORDER BY taxExpire DESC LIMIT(1)")
    suspend fun getExpiringTaxMoto() : Motor

}