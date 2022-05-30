package com.example.provacomponenti.utils

import android.content.Context
import com.example.provacomponenti.R
import java.io.IOException

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {

        jsonString = context.resources.openRawResource(R.raw.motor).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

/*
private fun loadJSONArrayMoto(context: Context): JSONArray? {
    //obtaining input
    val inputMotoStream = context.resources.openRawResource(R.raw.motor)

    BufferedReader(inputMotoStream.reader()).use {
        return JSONArray(it.readText())
    }
}*/