package com.example.provacomponenti.CommonItem

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TopBarSec(string: String){
    val navArrow = "home"
    TopAppBar(
        title = { Text(string) },
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        })
}