package com.example.provacomponenti.newsAnimation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.provacomponenti.Database.newImageList
import com.example.provacomponenti.Database.newsList

@Composable
fun SwipeCardAnimation() {
    CardStack(
        cardContent = { index ->
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(320.dp)
                    .padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(4.dp))
                AsyncImage(
                    modifier = Modifier.height(220.dp),
                    model = newImageList[index],
                    contentDescription = null
                )
                newsList.get(index).title?.let {
                    Text(
                        it,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                newsList.get(index).content?.let {
                    Text(
                        it,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))

            }


        }, cardCount = newsList.size
    )


}