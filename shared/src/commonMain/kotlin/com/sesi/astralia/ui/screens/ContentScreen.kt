package com.sesi.astralia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import astralia.shared.generated.resources.Res
import astralia.shared.generated.resources.loading
import coil3.compose.AsyncImage
import com.sesi.astralia.domain.dto.ContentCompleteDto
import com.sesi.astralia.domain.dto.ContentTypeDto
import com.sesi.astralia.presenter.viewmodel.ContentState
import com.sesi.astralia.presenter.viewmodel.ContentViewModel
import com.sesi.astralia.ui.navigation.NavData
import com.sesi.astralia.ui.theme.Background
import com.sesi.astralia.ui.theme.CelestialSoulTheme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ContentScreen(
    viewModel: ContentViewModel = koinViewModel(),
    navController: NavHostController) {
    val state: ContentState by viewModel.state.collectAsStateWithLifecycle()
    viewModel.getContentBySubCategoryId(NavData.subCategoryId!!)
    when(state) {
        is ContentState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize().testTag(stringResource(Res.string.loading)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is ContentState.Success -> {
            val response = (state as ContentState.Success).content
            BodyContent(response,navController)
        }
        is ContentState.Error -> {}
    }

}

@Composable
fun BodyContent(response: List<ContentCompleteDto>, navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(pageCount = {response.first().contentType.size})
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()) { page ->
            ItemContent(response.first().contentType[page])
        }
    }
}

@Composable
fun ItemContent(item: ContentTypeDto) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(350.dp)) {
            val gradient = Brush.linearGradient(
                colors = listOf(Background.copy(alpha = 0.1f), Background.copy(alpha = 0.7f)),
                start = Offset(0f,0f),
                end = Offset(0f, 500f)
            )
            AsyncImage(
                model = item.image,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxWidth().height(350.dp)
                    .drawWithContent{
                        drawContent()
                        drawRect(brush = gradient)
                    },
                alpha = 0.8f
            )
            Column(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    minLines = 3,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

        }

        Column(
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            val cardShape = RoundedCornerShape(12)
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f),
                        shape = cardShape
                    ),
                shape = cardShape,
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.onSecondary.copy(
                        alpha = 0.3f
                    )
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {

                Text(
                    text = "Caracteristicas:",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp),
                    textAlign = TextAlign.Start
                )
                val characteristics = item.characteristics.split("|")
                Column(
                    modifier = Modifier.padding(
                        start = 32.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    characteristics.forEach { characteristic ->
                        Text(
                            text = characteristic,
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
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f),
                        shape = cardShape
                    )
                    .padding(top = 16.dp),
                shape = cardShape,
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.onSecondary.copy(
                        alpha = 0.3f
                    )
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Text(
                    text = "Elemento: ${item.element}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Simbolo: ${item.symbol}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Virtud: ${item.virtue}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, bottom = 16.dp),
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
        val response = mutableListOf<ContentCompleteDto>()
        val contentType = ContentTypeDto(
            id = 1L, title = "Name", description = "Description",
            image = "",
            contentId = 2L,
            element = "fuego",
            symbol = "Luna",
            virtue = "Valor",
            characteristics = "e1|e2|e3"
        )
        val contentCompleteDto = ContentCompleteDto(
            id = 1L,
            name = "Name",
            description = "Description",
            contentType = listOf(contentType)
        )
        response.add(contentCompleteDto)
        BodyContent(response, rememberNavController())
    }
}
