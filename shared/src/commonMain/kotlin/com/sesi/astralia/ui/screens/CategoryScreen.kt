package com.sesi.astralia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sesi.astralia.ui.composables.MainCategoryCard
import com.sesi.astralia.ui.theme.CelestialSoulTheme

@Composable
fun CategoryScreen() {
    Column(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.padding(start = 16.dp, end = 16.dp),verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(10) {
                MainCategoryCard()
            }
        }
    }
}

@Preview
@Composable
fun PreviewCategoryScreen() {
    CelestialSoulTheme {
        CategoryScreen()
    }
}