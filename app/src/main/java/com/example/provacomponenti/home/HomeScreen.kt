package com.example.provacomponenti.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.Database.MotorEvent
import com.example.provacomponenti.Database.MotorViewModel
import com.example.provacomponenti.Database.TrackEvent
import com.example.provacomponenti.Database.TrackViewModel
import com.example.provacomponenti.commonItem.FabMaps
import com.example.provacomponenti.home.bottomBar.BottomNavigationBar
import com.example.provacomponenti.home.topBar.TopBar
import com.example.provacomponenti.login.user
import com.example.provacomponenti.newsAnimation.SwipeCardAnimation

@Composable
fun HomeScreen(motorViewModel: MotorViewModel, trackViewModel: TrackViewModel,navController:NavController) {

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopBar(navController) },
        floatingActionButton = { FabMaps(navController ) },
        content = {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                item { Spacer(modifier = Modifier.height(18.dp)) }
                item {
                    Surface(
                        modifier = Modifier
                            .padding(6.dp)
                            .fillMaxWidth(1f), shape = MaterialTheme.shapes.medium
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth(0.9f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                "Benvenuto $user",
                                fontSize = 28.sp,
                                style = MaterialTheme.typography.h4,
                                textAlign = TextAlign.Left,
                                modifier = Modifier.padding(4.dp)
                            )
                            Text(
                                "Su MotorTracks potrai gestire tutte le tue tracce gps preferite e utilizzare quelle messe a disposizione dalla community," +
                                        " inoltre potrai tenere sotto controllo le stato delle tue moto.",
                                style = MaterialTheme.typography.body1,
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }


                //--------------------Sezione moto in manutenzion--------------------------------//
                item {
                    Text(
                        text = "Overview Moto",
                        style = MaterialTheme.typography.h5
                    )
                }

                item {
                    LazyRow(modifier = Modifier.padding(start = 8.dp)) {
                        item {
                            Surface(
                                color = MaterialTheme.colors.background,
                                modifier = Modifier
                                    .padding(top = 12.dp, bottom = 12.dp)
                                    .fillMaxWidth(0.8f)
                                    .border(
                                        2.dp,
                                        MaterialTheme.colors.surface,
                                        shape = MaterialTheme.shapes.medium
                                    ),
                                shape = MaterialTheme.shapes.medium,
                                elevation = 4.dp,
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp)
                                ) {
                                    Text(
                                        "Assicurazione in scadenza",
                                        style = MaterialTheme.typography.subtitle1,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    var expiringInsMoto = getExpiringInsuranceMoto(motorViewModel)
                                    var modelIns = expiringInsMoto[0]
                                    var dateIns = expiringInsMoto[1]
                                    Text(
                                        "Moto: $modelIns",
                                        style = MaterialTheme.typography.body1
                                    )
                                    Text(
                                        "Scadenza: $dateIns ",
                                        style = MaterialTheme.typography.body1
                                    )

                                }


                            }

                        }
                        item {
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        item {
                            Surface(
                                color = MaterialTheme.colors.background,
                                modifier = Modifier
                                    .padding(top = 12.dp, bottom = 12.dp)
                                    .fillMaxWidth(0.8f)
                                    .border(
                                        2.dp,
                                        MaterialTheme.colors.surface,
                                        shape = MaterialTheme.shapes.medium
                                    ),
                                shape = MaterialTheme.shapes.medium,
                                elevation = 4.dp
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),

                                ) {
                                    Text(
                                        "Bollo in scadenza",
                                        style = MaterialTheme.typography.subtitle1,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    var expiringTaxMoto = getExpiringTaxMoto(motorViewModel)
                                    var motorTax = expiringTaxMoto[0]
                                    var dateTax = expiringTaxMoto[1]
                                    Text(
                                        "Moto: $motorTax",
                                        style = MaterialTheme.typography.body1
                                    )
                                    Text(
                                        "Scadenza: $dateTax",
                                        style = MaterialTheme.typography.body1
                                    )

                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        item {
                            Surface(
                                color = MaterialTheme.colors.background,
                                modifier = Modifier
                                    .padding(top = 12.dp, bottom = 12.dp)
                                    .fillMaxWidth(0.8f)
                                    .border(
                                        2.dp,
                                        MaterialTheme.colors.surface,
                                        shape = MaterialTheme.shapes.medium
                                    ),
                                shape = MaterialTheme.shapes.medium,
                                elevation = 4.dp
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp)
                                ) {
                                    Text(
                                        "Moto più potente",
                                        style = MaterialTheme.typography.subtitle1,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    var powerMoto = getPowerMoto(motorViewModel)
                                    var hpMotoModel = powerMoto[0]
                                    var hpMoto = powerMoto[1]
                                    Text(
                                        "Modello: $hpMotoModel",
                                        style = MaterialTheme.typography.body1
                                    )
                                    Text("Potenza: $hpMoto hp")
                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                    }
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                //--------------------sezione notizie---------------------------------------//
                item { Text(text = "Notizie", style = MaterialTheme.typography.h5) }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item { SwipeCardAnimation() }

                item { Spacer(modifier = Modifier.height(24.dp)) }
                //--------------------fine sezione notizie---------------------------------------//

                item { Spacer(modifier = Modifier.height(90.dp)) }
            }
        })
}

fun getExpiringInsuranceMoto(motorViewModel: MotorViewModel): List<String?> {
    motorViewModel.onTriggerEvent(MotorEvent.GetExpiringInsMoto)
    var a = listOf(motorViewModel.insuranceMotor, motorViewModel.insuranceDate)
    return a
}

fun getExpiringTaxMoto(motorViewModel: MotorViewModel): List<String?> {
    motorViewModel.onTriggerEvent(MotorEvent.GetExpiringTaxMoto)
    var b = listOf(motorViewModel.taxMotor, motorViewModel.taxDate)
    return b
}

fun getPowerMoto(motorViewModel: MotorViewModel): List<String?> {
    motorViewModel.onTriggerEvent(MotorEvent.GetPowerMoto)
    var c = listOf(motorViewModel.powerMotoModel,motorViewModel.powerMoto)
    return  c
}
/*
fun getLatestTrack(trackViewModel: TrackViewModel) : String?{
    trackViewModel.onTriggerEvent(TrackEvent.GetLatestTrack)
    return trackViewModel.lastTrack
}*/




