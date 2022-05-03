package com.example.provacomponenti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.provacomponenti.Home.HomeScreen
import com.example.provacomponenti.Model.motors
import com.example.provacomponenti.Model.tracks
import com.example.provacomponenti.ui.theme.ProvaComponentiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvaComponentiTheme {
                // A surface container using the 'background' color from the theme
                //CardNewMoto()
                //Greetings(motors)
                //TrackCard(tracks)
                HomeScreen()

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProvaComponentiTheme {

    }
}