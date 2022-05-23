package com.example.provacomponenti.CommonItem

import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.provacomponenti.R
import com.example.provacomponenti.viewModel.PermissionViewModel
import java.util.jar.Manifest

@Composable
fun FabMaps(navController: NavController){
    val fabNav = "maps"
    val scaffoldState = rememberScaffoldState()
    val permissionViewModel = PermissionViewModel()

    FloatingActionButton(
        onClick = {
                  permissionViewModel.setPerformLocationAction(true)


            /*
            navController.navigate(fabNav) {
            navController.graph.startDestinationRoute?.let { route ->
                popUpTo(route) {
                    saveState = true
                }
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }*/},
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = FloatingActionButtonDefaults.elevation(8.dp)
    ) {
        Icon(painterResource(id = R.drawable.ic_pin), "pin")
    }

}