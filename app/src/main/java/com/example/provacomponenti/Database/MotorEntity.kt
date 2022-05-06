package com.example.provacomponenti.Database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Moto(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val brand: String?,
    val model: String?,
    val displacement: String?, //cilindrata
    val typeOfMoto: String?, //Dual, naked, carenata, etc
    val hp: Float?,
    val kg: Float?,
    val taxExpire: Int?, //scadenza bollo
    val insuranceExpire: Int?,
    val imageURL : String?
)