package com.example.provacomponenti.Database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Track(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val name: String?,
    val km: Int?,
    val description: String?,
    val typeOfTrack: String?, // sterrato, strada, etc
    val difficulty: String?, //facile medio difficile
    val imageURL: String?
)
var tracks = listOf(
    Track(
        1,"Monte della Birra",55,"Sterrato  nelle campagne romagnole",
        "Sterrato", "Media","pooj"
    ),
    Track(
        2,"Muraglione",175,"Uno dei passi più famosi in Italia",
        "Stradale", "Media","pooj"
    )

)