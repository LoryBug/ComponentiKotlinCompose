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

var motors = listOf(
    Motor(
        1,"Honda", "Dominator","650cc","Dual",40,160,290522,301022,"caio"
    ),
    Motor(
        2,"Yamaha", "Teneré","700cc","Dual",72,202,290522,301022,"caio"
    ),
    Motor(
        3," Ducati", "V4s","1100cc","Carenata",203,175,290522,301022,"caio"
    ),

)