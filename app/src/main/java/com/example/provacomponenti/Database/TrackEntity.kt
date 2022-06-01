package com.example.provacomponenti.Database


import androidx.room.Entity
import androidx.room.PrimaryKey

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
        "Sterrato", "https://photos.worldtravelserver.com/photo/2153/medium/8310966.jpg"
    ),
    Track(
        "2","Muraglione","175","Uno dei passi più famosi in Italia",
        "Stradale", "http://documenti.egaf.it/Test_JS_mpeg/F75D81/HondasNS440R.jpg\n"
    ),
    Track(
        "3","Passo Centocroci","31","Il passo CentoCroci è un valico appenninico posto sul confine tra Emilia Romagna e Liguria.",
        "Stradale",""
    ),
    Track("4","Passo del Muraglione","41", "Meta obbligatoria per un motociclista è considerata una delle mete più ambite d’Italia che unisce storia, natura e passione in un unico viaggio.",
    "Stradale","M"),

    Track("5","Passo della Penice","31","Il passo della Penice è un valico che mette in comunicazione la Valle Staffora Lombarda con la Val Trebbia dell’Emilia Romagna",
    "Stradale","https://github.com/LoryBug/projectImage/blob/main/PassoDellaPenice.png"),

    Track("6","Lago Trasimeno","67","Immerso in uno splendido contesto, un motociclista potrà apprezzare questo bellissimo itinerario e passare una piacevole giornata.",
    "Stradale","https://github.com/LoryBug/projectImage/blob/main/lagoTrasimeno.png"),

    Track("7","Monti Sibillini","237","Il Parco Nazionale dei Monti Sibillini è collocato nel cuore dell’Italia, tra le Marche e l’Umbria",
    "Stradale","")


)