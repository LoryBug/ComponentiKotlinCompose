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
    )
)

var newImageList = listOf(
    "https://cdn.visordown.com/styles/v2_large/s3/field/image/nx2.png?itok=L2JtLf0M",
    "https://www.motociclismo.it/files/galleries/1/9/7/19781/B_2022-yam-xs850-eu-bmc-act-002-03-preview.jpg",
    "https://www.targetmotori.com/wp-content/uploads/2022/04/33795.jpg"
)