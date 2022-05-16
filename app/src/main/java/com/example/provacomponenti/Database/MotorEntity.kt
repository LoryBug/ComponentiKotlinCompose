package com.example.provacomponenti.Database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Motor(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val brand: String?,
    val model: String?,
    val displacement: String?, //cilindrata
    val typeOfMoto: String?, //Dual, naked, carenata, etc
    val hp: Int?,
    val kg: Int?,
    val taxExpire: Int?, //scadenza bollo
    val insuranceExpire: Int?,
    val imageURL : String?
)