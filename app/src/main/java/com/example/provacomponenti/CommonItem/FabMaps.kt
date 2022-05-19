package com.example.provacomponenti.CommonItem

import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.provacomponenti.R
import java.util.jar.Manifest

@Composable
fun FabMaps(navController: NavController){
    val fabNav = "maps"
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()){
        isGranted:Boolean->
        if (isGranted){/*
            Log.d("ExampleScreen","PERMISSION GRANTED")
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
            }
       */ } else {

        }
    }
    val context = LocalContext.current




    FloatingActionButton(
        onClick = { /*navController.navigate(fabNav) {
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
        } */
                  when(PackageManager.PERMISSION_GRANTED){
                      ContextCompat.checkSelfPermission(context,
                          android.Manifest.permission.READ_EXTERNAL_STORAGE
                      )->{
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
                          }

                      }
                      else->{
                          launcher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                      }

                  }
                  },
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = FloatingActionButtonDefaults.elevation(8.dp)
    ) {
        Icon(painterResource(id = R.drawable.ic_pin), "pin")
    }
}