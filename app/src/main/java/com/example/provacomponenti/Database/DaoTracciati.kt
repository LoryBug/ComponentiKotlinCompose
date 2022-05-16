package com.example.provacomponenti.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TracciatiDAO{

    @Insert(onConflict = OnConflictStrategy.IGNORE) //  INSERIMENTO TRACCIATO
    suspend fun insertTrack(tracciati: Track)

    @Query("SELECT * FROM Track")
    fun getTracciati() : List<Track>

    @Query("SELECT * FROM Track WHERE km<75")
    fun getShortTrack() : List<Track>

}
