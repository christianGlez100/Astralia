package com.sesi.astralia.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sesi.astralia.domain.dto.SubCategoryDto
import com.sesi.astralia.ui.theme.CelestialSoulTheme
import com.sesi.astralia.ui.theme.SurfaceBright

@Composable
fun SubCategoryCard(item: SubCategoryDto, onClick: (id:Long) -> Unit = {}) {
    val cardShape = RoundedCornerShape(12)
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(width = 2.dp, color = SurfaceBright, shape = cardShape)
            .clickable{onClick(item.id)},
        shape = cardShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ){
        Box(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
            Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.width(100.dp).fillMaxHeight()
                )
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 3,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }


}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewSubCategoryCard() {
    CelestialSoulTheme {
        SubCategoryCard(
            SubCategoryDto(
                id = 1,
                name = "Mysticism",
                imageUrl = "",
                description = "Description",
                categoryId = 1
            )
        )
    }
}