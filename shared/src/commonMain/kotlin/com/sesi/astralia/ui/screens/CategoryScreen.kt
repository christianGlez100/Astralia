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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import astralia.shared.generated.resources.Res
import astralia.shared.generated.resources.loading
import com.sesi.astralia.domain.dto.CategoryDto
import com.sesi.astralia.presenter.viewmodel.CategoryState
import com.sesi.astralia.presenter.viewmodel.CategoryViewModel
import com.sesi.astralia.ui.composables.MainCategoryCard
import com.sesi.astralia.ui.navigation.Routes
import com.sesi.astralia.ui.theme.CelestialSoulTheme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = koinViewModel(),
    navController: NavHostController
) {
    val state: CategoryState by viewModel.state.collectAsStateWithLifecycle()
    GetCategories(viewModel)
    when(state) {
        is CategoryState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize().testTag(stringResource(Res.string.loading)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is CategoryState.Success -> {
            val response = (state as CategoryState.Success).categories
            BodyCategory(response, navController)
        }
        is CategoryState.Error -> {}
    }

}

@Composable
fun BodyCategory(response: List<CategoryDto>, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.padding(start = 16.dp, end = 16.dp),verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(response) { item ->
                MainCategoryCard(item) { categoryId ->
                    navController.navigate(
                        Routes.SubCategory.createRoute(
                            categoryId,
                            item.name,
                            item.description
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun GetCategories(viewModel: CategoryViewModel){
    LaunchedEffect(Unit){
        viewModel.getAllCategories()
    }
}

@Preview
@Composable
fun PreviewCategoryScreen() {
    val cat = CategoryDto(id = 1, name = "Mysticism", imageUrl = "", order = 1, description = "Description")
    val categories = listOf(cat)
    CelestialSoulTheme {
        BodyCategory(categories, rememberNavController())
    }
}