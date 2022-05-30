package com.example.provacomponenti.Database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Motor::class, Track::class], version = 1, exportSchema = false)
abstract class MotorTracksDatabase :RoomDatabase() {

    abstract fun motorDao(): MotorDAO

    abstract fun trackDao(): TrackDAO

    companion object{
        const val DATABASE_NAME = "motortrack_db"
    }
}