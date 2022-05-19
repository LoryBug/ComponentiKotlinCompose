package com.example.provacomponenti.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.provacomponenti.CommonItem.FloatingActionButtons
import com.example.provacomponenti.Home.BottomBar.BottomNavigationBar
import com.example.provacomponenti.Home.TopBar.TopBar
import com.example.provacomponenti.R

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopBar() },
        content = {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                //--------------------sezione notizie---------------------------------------//
                item {
                    Surface(
                        color = MaterialTheme.colors.background,
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(0.8f),
                        border = BorderStroke(
                            2.dp,
                            MaterialTheme.colors.primary
                        ),
                        shape = MaterialTheme.shapes.medium,
                        elevation = 4.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Notizie",
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a condimentum nunc," +
                                        " a sollicitudin quam. Vestibulum ante ipsum primis in faucibus orci luctus et " +
                                        "ultrices posuere cubilia curae; Mauris accumsan vitae leo non pharetra. Orci varius " +
                                        "natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus" +
                                        " in eros mauris. Ut id est vitae arcu sodales blandit. In iaculis nisl et erat " +
                                        "egestas, quis dapibus arcu sagittis. Sed rutrum est sit amet porta dictum." +
                                        " Aliquam hendrerit euismod dolor, id interdum leo cursus ut. Donec pellentesque accumsan " +
                                        "magna vel vehicula. Maecenas nec libero fermentum, pellentesque tortor vel," +
                                        " mattis mauri",
                                style = MaterialTheme.typography.body1
                            )

                        }


                    }
                }
                item { Spacer(modifier = Modifier.height(24.dp)) }
                //--------------------fine sezione notizie---------------------------------------//
                item { Text(text = "Moto in manutenzione", style = MaterialTheme.typography.h5) }

                item {
                    LazyRow(modifier = Modifier.padding(start = 8.dp)) {
                        item {
                            Surface(
                                color = MaterialTheme.colors.background,
                                modifier = Modifier
                                    .padding(top = 12.dp)
                                    .fillMaxWidth(0.8f),
                                border = BorderStroke(
                                    2.dp,
                                    MaterialTheme.colors.primary
                                ),
                                shape = MaterialTheme.shapes.medium,
                                elevation = 4.dp
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "In manutenzione",
                                        style = MaterialTheme.typography.subtitle1,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(
                                        "Rinnovare assicurazione",
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
                                    .padding(top = 12.dp)
                                    .fillMaxWidth(0.8f),
                                border = BorderStroke(
                                    2.dp,
                                    MaterialTheme.colors.primary
                                ),
                                shape = MaterialTheme.shapes.medium,
                                elevation = 4.dp
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "In Manutenzione",
                                        style = MaterialTheme.typography.subtitle1,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(
                                        "Pagare bollo",
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
                                    .padding(top = 12.dp)
                                    .fillMaxWidth(0.8f),
                                border = BorderStroke(
                                    2.dp,
                                    MaterialTheme.colors.primary
                                ),
                                shape = MaterialTheme.shapes.medium,
                                elevation = 4.dp
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "Assicurazioni in scadenza",
                                        style = MaterialTheme.typography.subtitle1,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(
                                        "Tua mamma è in scadenza",
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                    }
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item { Text(text = "Suca Suca", style = MaterialTheme.typography.h5) }

                item {
                    Surface(
                        color = MaterialTheme.colors.background,
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(0.8f),
                        border = BorderStroke(
                            2.dp,
                            MaterialTheme.colors.primary
                        ),
                        shape = MaterialTheme.shapes.medium,
                        elevation = 4.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Notizie",
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a condimentum nunc," +
                                        " a sollicitudin quam. Vestibulum ante ipsum primis in faucibus orci luctus et " +
                                        "ultrices posuere cubilia curae; Mauris accumsan vitae leo non pharetra. Orci varius " +
                                        "natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus" +
                                        " in eros mauris. Ut id est vitae arcu sodales blandit. In iaculis nisl et erat " +
                                        "egestas, quis dapibus arcu sagittis. Sed rutrum est sit amet porta dictum." +
                                        " Aliquam hendrerit euismod dolor, id interdum leo cursus ut. Donec pellentesque accumsan " +
                                        "magna vel vehicula. Maecenas nec libero fermentum, pellentesque tortor vel," +
                                        " mattis mauri",
                                style = MaterialTheme.typography.body1
                            )

                        }


                    }
                }
                item { Spacer(modifier = Modifier.height(90.dp)) }
            }
        })
}





