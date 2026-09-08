package com.sesi.astralia.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import astralia.shared.generated.resources.Res
import astralia.shared.generated.resources.mysticism
import coil3.compose.AsyncImage
import com.sesi.astralia.ui.theme.CelestialSoulTheme
import com.sesi.astralia.ui.theme.SurfaceBright

@Composable
fun ContentScreen() {
    BodyContent()
}

@Composable
fun BodyContent() {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(350.dp)) {
            AsyncImage(
                model = Res.drawable.mysticism,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxWidth().height(350.dp),
                alpha = 0.8f
            )
            Column(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Las Hadas",
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "sda",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    minLines = 3,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

        }

        Column(modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
            val cardShape = RoundedCornerShape(12)
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .border(width = 2.dp, color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f), shape = cardShape),
                shape = cardShape,
                colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.3f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {

                Text(
                    text = "Caracteristicas:",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp),
                    textAlign = TextAlign.Start
                )
                LazyColumn(
                    modifier = Modifier.padding(start = 32.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(5) {
                        Text(
                            text = "sda",
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 1,
                            minLines = 1,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .border(width = 2.dp, color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f), shape = cardShape)
                    .padding(top = 16.dp),
                shape = cardShape,
                colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.3f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Text(
                    text = "Elemento:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Simbolo:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Virtud:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp, bottom = 16.dp),
                    textAlign = TextAlign.Start
                )
            }


        }


    }
}

@Preview
@Composable
fun PreviewContentScreen() {
    CelestialSoulTheme {
        BodyContent()
    }
}
