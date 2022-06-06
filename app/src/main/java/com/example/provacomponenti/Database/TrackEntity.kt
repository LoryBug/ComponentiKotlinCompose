package com.example.provacomponenti.Database


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.provacomponenti.R

@Entity
data class Track(
    @PrimaryKey val id : String,
    var name: String?,
    var km: String?,
    var description: String?,
    var typeOfTrack: String?, // sterrato, strada, etc
    val imageURL: String?
)

var tracks = listOf(
    Track(
        "1","Monte della Birra","55","Sterrato  nelle campagne romagnole",
        "Sterrato", "R.drawable.montedellabirra"
    ),
    Track("4","Passo del Muraglione","41", "Meta obbligatoria per un motociclista è considerata una delle mete più ambite d’Italia che unisce storia, natura e passione in un unico viaggio.",
    "Stradale", "R.drawable.muraglione"),

    Track("5","Passo della Penice","31","Il passo della Penice è un valico che mette in comunicazione la Valle Staffora Lombarda con la Val Trebbia dell’Emilia Romagna",
    "Stradale","R.drawable.passodellapenice"),

    Track("6","Lago Trasimeno","67","Immerso in uno splendido contesto, un motociclista potrà apprezzare questo bellissimo itinerario e passare una piacevole giornata.",
    "Stradale","R.drawable.ic_lagotrasimeno"),

    Track("7","Monti Sibillini","237","Il Parco Nazionale dei Monti Sibillini è collocato nel cuore dell’Italia, tra le Marche e l’Umbria",
    "Stradale","R.drawable.montisibillini")

)
data class TrackStatic(
    @PrimaryKey val id : String,
    var name: String?,
    var km: String?,
    var description: String?,
    var typeOfTrack: String?, // sterrato, strada, etc
    val imageRes: Int?
)

var trackStatic = listOf(
    TrackStatic(
        "1","Monte della Birra","55","Sterrato  nelle campagne romagnole",
        "Sterrato", R.drawable.montedellabirra
    ),
    TrackStatic("4","Passo del Muraglione","41", "Meta obbligatoria per un motociclista è considerata una delle mete più ambite d’Italia che unisce storia, natura e passione in un unico viaggio.",
        "Stradale", R.drawable.muraglione),

    TrackStatic("5","Passo della Penice","31","Il passo della Penice è un valico che mette in comunicazione la Valle Staffora Lombarda con la Val Trebbia dell’Emilia Romagna",
        "Stradale",R.drawable.passodellapenice),

    TrackStatic("6","Lago Trasimeno","67","Immerso in uno splendido contesto, un motociclista potrà apprezzare questo bellissimo itinerario e passare una piacevole giornata.",
        "Stradale",R.drawable.ic_lagotrasimeno),

    TrackStatic("7","Monti Sibillini","237","Il Parco Nazionale dei Monti Sibillini è collocato nel cuore dell’Italia, tra le Marche e l’Umbria",
        "Stradale",R.drawable.montisibillini)

)