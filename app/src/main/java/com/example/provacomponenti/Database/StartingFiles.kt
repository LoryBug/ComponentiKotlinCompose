package com.example.provacomponenti.Database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.provacomponenti.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.io.BufferedReader
import org.json.JSONException


class StartingFiles(private val context: Context) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
            fillWithStartingFiles(context)
        }
    }

    // filling data from json
    private suspend fun fillWithStartingFiles(context: Context) {
        // obtaining instance of dao
        val daoM = AppDatabase.getInstance(context)?.motorDao()
        val daoT = AppDatabase.getInstance(context)?.trackDao()

        try {
            val motor = loadJSONArrayMoto(context)
            val track = loadJSONArrayTrack(context)

            if(motor != null){
                for(i in 0 until motor.length()){
                    //obtain json obj
                    val itemMoto = motor.getJSONObject(i)
                    //assign data
                    val id = itemMoto.getInt("id")
                    val brand = itemMoto.getString("brand")
                    val model = itemMoto.getString("model")
                    val displacement = itemMoto.getString("displacement")
                    val typeOfMoto = itemMoto.getString("typeOfMoto")
                    val hp = itemMoto.getInt("hp")
                    val kg = itemMoto.getInt("kg")
                    val taxExp = itemMoto.getInt("taxExpire")
                    val insuranceExp = itemMoto.getInt("insuranceExpire")
                    val imageUrl = itemMoto.getString("imageURL")

                    //load data to the entity
                    val motoEntity = Motor(
                        id,brand,model,displacement,typeOfMoto, hp,kg,taxExp,insuranceExp,imageUrl)
                    daoM?.insertMoto(motoEntity)
                }
            }

            if (track != null){
                for(i in 0 until track.length()){
                    val itemTrack = track.getJSONObject(i)

                    val id = itemTrack.getInt("id")
                    val name = itemTrack.getString("name")
                    val km = itemTrack.getInt("km")
                    val description = itemTrack.getString("description")
                    val type = itemTrack.getString("typeOfTrack")
                    val diff = itemTrack.getString("difficulty")
                    val imageUrl = itemTrack.getString("imageURL")

                    val trackEntity = Track(id,name,km, description,type,diff,imageUrl)
                    daoT?.insertTrack(trackEntity)

                }
            }
        }
        catch (e: JSONException) {

        }
    }
    private fun loadJSONArrayMoto(context: Context): JSONArray? {
        //obtaining input
        val inputMotoStream = context.resources.openRawResource(R.raw.motor)

        BufferedReader(inputMotoStream.reader()).use {
            return JSONArray(it.readText())
        }
    }

    private fun loadJSONArrayTrack(context: Context) : JSONArray?{
        val inputTrackStream = context.resources.openRawResource(R.raw.tracks)
        BufferedReader(inputTrackStream.reader()).use {
            return JSONArray(it.readText())
        }
    }
}