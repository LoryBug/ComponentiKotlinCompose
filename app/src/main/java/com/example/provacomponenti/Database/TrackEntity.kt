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
    val imageURL: String?
)
var tracks = listOf(
    Track(
        1,"Monte della Birra",55,"Sterrato  nelle campagne romagnole",
        "Sterrato", "pooj"
    ),
    Track(
        2,"Muraglione",175,"Uno dei passi più famosi in Italia",
        "Stradale", "pooj"
    ),
    Track(
        3,"Passo Centocroci",31,"Il passo CentoCroci è un valico appenninico posto sul confine tra Emilia Romagna e Liguria.",
        "Stradale",""
    ),
    Track(4,"Passo del Muraglione",41, "Meta obbligatoria per un motociclista è considerata una delle mete più ambite d’Italia che unisce storia, natura e passione in un unico viaggio.",
    "Stradale","M"),

    Track(5,"Passo della Penice",31,"Il passo della Penice è un valico che mette in comunicazione la Valle Staffora Lombarda con la Val Trebbia dell’Emilia Romagna",
    "Stradale",""),

    Track(6,"Lago Trasimeno",67,"Immerso in uno splendido contesto, un motociclista potrà apprezzare questo bellissimo itinerario e passare una piacevole giornata.",
    "Stradale",""),

    Track(7,"Monti Sibillini",237,"Il Parco Nazionale dei Monti Sibillini è collocato nel cuore dell’Italia, tra le Marche e l’Umbria",
    "Stradale","")


)