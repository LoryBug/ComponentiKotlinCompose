package com.example.provacomponenti.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TracciatiDAO{

    @Insert(onConflict = OnConflictStrategy.IGNORE) //  INSERIMENTO TRACCIATO
    suspend fun insertTrack(tracciati: Tracciati)

    @Query("SELECT * FROM tracciati")
    fun getTracciati() : List<Tracciati>

    @Query("SELECT * FROM tracciati WHERE km<75")
    fun getShortTrack() : List<Tracciati>

}
