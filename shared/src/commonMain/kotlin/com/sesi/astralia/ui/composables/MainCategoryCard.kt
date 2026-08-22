package com.sesi.astralia.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import astralia.shared.generated.resources.Res
import astralia.shared.generated.resources.mysticism
import com.sesi.astralia.ui.theme.CelestialSoulTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainCategoryCard() {
    val cardShape = RoundedCornerShape(13)
    ElevatedCard(
        modifier = Modifier.fillMaxWidth().height(300.dp)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.tertiary, shape = cardShape),
        shape = cardShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                modifier = Modifier.fillMaxSize().background(brush = gradient),
                painter = painterResource(Res.drawable.mysticism),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Mysticism",
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Text(
                    text = "El misticismo es unav adasdad asdsdre dosdasdsdsdsdasnde encontratras asdada. asdadasdasdadadasdas.adasdasd",
                    maxLines = 3,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

        }


    }
}

val gradient = Brush.linearGradient(
    colors = listOf(Color.White, Color.Black)
)

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewCard() {
    CelestialSoulTheme {
        MainCategoryCard()
    }
}