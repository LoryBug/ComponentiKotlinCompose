package com.example.provacomponenti.Database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tracciati(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val name: String?,
    val km: Float?,
    val description: String?,
    val typeOfTrack: String?, // sterrato, strada, etc
    val difficulty: String?, //facile medio difficile
    val imageURL: String?
)
