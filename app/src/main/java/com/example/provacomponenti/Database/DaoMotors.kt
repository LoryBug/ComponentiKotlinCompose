package com.example.provacomponenti.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MotorDAO{
    //----------------------------------    MOTO    ------------------------------------//

    @Insert(onConflict = OnConflictStrategy.IGNORE) //  INSERIMENTO MOTO
    suspend fun insertMoto(moto: Moto)

    @Query("SELECT * FROM moto")
    fun getMotors() : List<Moto>

    @Query("SELECT * FROM moto ORDER BY insuranceExpire DESC LIMIT(1)")
    fun getExpiringInsMoto() : Moto

    @Query("SELECT * FROM moto ORDER BY taxExpire DESC LIMIT(1)")
    fun getExpiringTaxMoto() : Moto

}