package com.example.provacomponenti.Database

data class FavouritePlace(
    val lat : Double,
    val lon: Double,
    val title : String?
)

var favPlaceList = listOf(
    FavouritePlace(
        44.255570846189435, 12.363348295993113, "Fantini Club"
    ),
    FavouritePlace(
        44.18508093991043, 11.959538562082507, "Bar Due Borghi"
    ),
    FavouritePlace(
        43.860112798045854,11.744338869218332, "Passo della Calla"
    ),
    FavouritePlace(
        44.517083919792974, 11.268057775422696,"Museo Ducati"
    ),
    FavouritePlace(
        44.654313993263386, 10.935396932815417,"Museo Ferrari"
    ),
    FavouritePlace(
        44.140829718022985, 12.231071591307101,"Eni Station"
    ),
    FavouritePlace(
        44.19907531340166, 12.021297947078736, "Oro Nero"
    ),

)