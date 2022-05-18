package com.example.provacomponenti.Prova.DataBaseProva

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.provacomponenti.Database.*

@Database(entities = [Motor::class,Track::class], version = 1, exportSchema = false)
abstract class DatabaseProva : RoomDatabase(){
    abstract fun motorDao(): MotorDAO
    abstract fun trackDao():TrackDAO

    companion object{
        @Volatile
        private var INSTANCE: DatabaseProva? = null

        fun getDB(context: Context):DatabaseProva{
            val tmpInstance = INSTANCE
            if(tmpInstance!=null){
                return tmpInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                DatabaseProva::class.java, "jetpack")
                    .addCallback(StartingFiles(context))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}