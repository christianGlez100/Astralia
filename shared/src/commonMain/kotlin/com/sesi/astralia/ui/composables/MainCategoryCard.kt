package com.sesi.astralia.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sesi.astralia.data.model.Category
import com.sesi.astralia.domain.dto.CategoryDto
import com.sesi.astralia.ui.theme.Background
import com.sesi.astralia.ui.theme.CelestialSoulTheme

@Composable
fun MainCategoryCard(item: CategoryDto, onClick: (id:Long) -> Unit = {}) {
    val cardShape = RoundedCornerShape(6)
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.tertiary, shape = cardShape)
            .clickable{ onClick(item.id)},
        shape = cardShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = "",
                modifier = Modifier.fillMaxSize().background(brush = gradient),
                contentScale = ContentScale.FillBounds
            )
           /* Image(
                modifier = Modifier.fillMaxSize().background(brush = gradient),
                painter = painterResource(Res.drawable.mysticism),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )*/
            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Text(
                    text = item.description,
                    maxLines = 3,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

        }


    }
}

val gradient = Brush.linearGradient(
    colors = listOf(Background.copy(alpha = 0.2f), Background),
    start = Offset(0f,0f),
    end = Offset(0f, 500f)
)

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewCard() {
    CelestialSoulTheme {
        MainCategoryCard(CategoryDto(id = 1, name = "Mysticism", imageUrl = "", order = 1, description = "Description"))
    }
}