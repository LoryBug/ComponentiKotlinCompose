package com.example.provacomponenti.Model

data class Motor(
    val id: String? = null,
    val brand: String? = null,
    val model: String? = null,
    val displacement: String? = null, //cilindrata
    val typeOfMoto: String? = null, //Dual, naked, carenata, etc
    val hp: Float? = null,
    val kg: Float? = null,
    val taxExpire: Int? = null, //scadenza bollo
    val insuranceExpire: Int? = null//scadenza assicurzione
)

val motors = listOf(     //mancano scadenze
    Motor(
        "#001", "Honda", "Dominator", "644cc", "Dual", 42.2f, 162.5f, ), //Dominator
    Motor(
        "#002", "Yamaha", "Teneré", "700cc", "Dual", 74.3f, 202.3f, ), //Teneré
    Motor(
        "#003", "Ducati", "Panigale V4", "1103cc", "Carenata", 215.5f, 175.0f, ), //Panigale

)

fun toStringMotor(motor : Motor): String {
    var id = motor.id
    var brand = motor.brand
    var model = motor.model
    var displacement = motor.displacement
    var typeOfMoto = motor.typeOfMoto
    var hp = motor.hp
    var kg = motor.kg
    var s : String = ""+ brand + "\n" + model + "\nCilindrata: "+ displacement +
            "\nCavalli: "+ hp + "\nPeso: " + kg + " Kg"+ "\nGenere: " + typeOfMoto
    return s
}