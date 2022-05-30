package com.example.provacomponenti.Database


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Motor(
    @PrimaryKey(autoGenerate = true) var id : Int,
    val brand: String?,
    val model: String?,
    val displacement: String?, //cilindrata
    val typeOfMoto: String?, //Dual, naked, carenata, etc
    val hp: Int?,
    val kg: Int?,
    val taxExpire: String?, //scadenza bollo
    val insuranceExpire: String?,
    val imageURL : String?
)


/*
var motorette = mutableListOf(
    Motor(
        1,"Honda", "Dominator","650cc","Dual",40,160,"290522","301022","https://cdn.inmoto.it/images/2021/02/19/181747538-f1c92825-4e21-4c33-bc17-a86c928c8988.jpg"
    ),
    Motor(
        2,"Yamaha", "Teneré","700cc","Dual",72,202,"290522","301022","https://h2v5h9c2.rocketcdn.me/wp-content/uploads/2022/03/Yamaha-Te%CC%81ne%CC%81re%CC%81-700-2022-34-1200x675-2.jpeg"
    ),
    Motor(
        3,"Ducati", "V4s","1100cc","Carenata",203,175,"290522","301022","https://i.ytimg.com/vi/oH1-OJe8pMI/maxresdefault.jpg"
    ),
)*/

var motors = listOf(
    Motor(
        1,"Honda", "Dominator","650cc","Dual",40,160,"290522","301022","https://cdn.inmoto.it/images/2021/02/19/181747538-f1c92825-4e21-4c33-bc17-a86c928c8988.jpg"
    ),
    Motor(
        2,"Yamaha", "Teneré","700cc","Dual",72,202,"290522","301022","https://h2v5h9c2.rocketcdn.me/wp-content/uploads/2022/03/Yamaha-Te%CC%81ne%CC%81re%CC%81-700-2022-34-1200x675-2.jpeg"
    ),
    Motor(
        3,"Ducati", "V4s","1100cc","Carenata",203,175,"290522","301022","https://i.ytimg.com/vi/oH1-OJe8pMI/maxresdefault.jpg"
    ),

)



/*
val jsonFileString = getJsonDataFromAsset(applicationContext, "bezkoder.json")
Log.i("data", jsonFileString)
val gson = Gson()
val listPersonType = object : TypeToken<List<Person>>() {}.type
var persons: List<Person> = gson.fromJson(jsonFileString, listPersonType)
persons.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n$person") }
 */