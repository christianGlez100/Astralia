package com.sesi.astralia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import astralia.shared.generated.resources.Res
import astralia.shared.generated.resources.loading
import com.sesi.astralia.domain.dto.SubCategoryDto
import com.sesi.astralia.presenter.viewmodel.SubCategoryState
import com.sesi.astralia.presenter.viewmodel.SubCategoryViewModel
import com.sesi.astralia.ui.composables.SubCategoryCard
import com.sesi.astralia.ui.navigation.NavData
import com.sesi.astralia.ui.navigation.Routes
import com.sesi.astralia.ui.theme.Background
import com.sesi.astralia.ui.theme.CelestialSoulTheme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SubCategoryScreen(
    viewModel: SubCategoryViewModel = koinViewModel(),
    navController: NavHostController
) {
    val state: SubCategoryState by viewModel.state.collectAsStateWithLifecycle()
    viewModel.getSubCategoriesByCategoryId(NavData.categoryId!!)

    when (state) {
        is SubCategoryState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize().testTag(stringResource(Res.string.loading)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is SubCategoryState.Success -> {
            val response = (state as SubCategoryState.Success).subCategories
            BodySubCategory(response, navController)
        }

        is SubCategoryState.Error -> {}
    }

}

@Composable
fun BodySubCategory(response: List<SubCategoryDto>, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize().background(gradientBkg))
            Column(
                modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = NavData.categoryName.orEmpty(),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = NavData.categoryDescription.orEmpty(),
                    maxLines = 3,
                    minLines = 3,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(response) { item ->
                        SubCategoryCard(item){ subCategoryId ->
                            NavData.subCategoryId = subCategoryId
                            navController.navigate(Routes.Content.route)
                        }
                    }
                }
            }


        }


    }
}

val gradientBkg = Brush.linearGradient(
    colors = listOf(Background, Background, Background, Background.copy(alpha = 0.2f)),
    start = Offset(0f, 0f),
    end = Offset(0f, 800f)
)

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewSubCategoryScreen() {
    CelestialSoulTheme {
        val subCategoryDto = SubCategoryDto(
            id = 1,
            name = "Mysticism",
            imageUrl = "",
            description = "Description",
            categoryId = 1
        )
        BodySubCategory(listOf(subCategoryDto), rememberNavController())
    }
}