package com.sesi.astralia.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sesi.astralia.ui.theme.CelestialSoulTheme
import com.sesi.astralia.ui.theme.CelestialTypography
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onItemClick: (NavigationItem) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach { navigationItem ->
            NavigationBarItem(
                selected = currentRoute == navigationItem.route,
                onClick = { onItemClick(navigationItem) },
                icon = {
                    Icon(
                        painter = if (navigationItem.route == currentRoute) painterResource(navigationItem.selectedIcon) else painterResource(navigationItem.unSelectedIcon),
                        contentDescription = navigationItem.title,
                    )
                },
                label = {
                    Text(
                        text = navigationItem.title,
                        style = CelestialTypography.labelMedium,
                        color = if (navigationItem.route == currentRoute) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1
                    )
                },
            )
        }
    }
}