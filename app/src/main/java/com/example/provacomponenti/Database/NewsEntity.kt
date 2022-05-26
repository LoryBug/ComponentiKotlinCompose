package com.example.provacomponenti.Database

data class News(
    val title : String?,
    val content : String?
)

var newsList = listOf(
    News(
        "Nuova NX500", "Honda registra i brevetti per la nuova erede del Dominator," +
                "questa volta in versione bicilindrica con il motore del CB500."
    ),
    News(
        "Yamaha XSR 900",
        "Si rinnova la naked retro di casa Yamaha, con ciclistica più sportiva e più elettronica" +
                "per maggiore sicurezza."
    ),
    News(
        "GasGas SM/ES 700", "Presentate le nuove monociclindriche su base KTM 690, la SM " +
                "in versione motard mentre la ES in versione enduro."
    ),
    News(
        "Ducati Desert X",
        "Arriva finalmente in commercio la nuova maxienduro di casa Ducati," +
                "110CV con cerchio anteriore da 21\" e orientamento offroad molto marcato. "
    ),
    News(
        "Ktm RC 8c 2022", " La KTM RC 8C è un prototipo leggero costruito appositamente per le competizioni con un motore LC8c 890 KTM, un telaio su misura"
    )
)

var newImageList = listOf(
    "https://s1.cdn.autoevolution.com/images/news/how-much-will-the-new-honda-dominator-resemble-this-rendering-105573_1.jpg",
    "https://www.motociclismo.it/files/galleries/1/9/7/19781/B_2022-yam-xs850-eu-bmc-act-002-03-preview.jpg",
    "https://www.targetmotori.com/wp-content/uploads/2022/04/33795.jpg",
    "https://img3.stcrm.it/images/28153360/1000x/20220504-015728188-2859.jpeg",
    "https://cdp.azureedge.net/products/USA/KT/2022/MC/SUPERSPORT/RC_8C/50/ORANGE/2000000003.jpg"
)