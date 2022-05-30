package com.example.provacomponenti.Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrackDAO{

    @Insert(onConflict = OnConflictStrategy.IGNORE) //  INSERIMENTO TRACCIATO
    suspend fun insertTrack(tracciati: Track)

    @Query("SELECT * FROM Track")
    fun getTrack() : LiveData<List<Track>>

    @Query("SELECT * FROM Track WHERE km<75")
    fun getShortTrack() : List<Track>

}
