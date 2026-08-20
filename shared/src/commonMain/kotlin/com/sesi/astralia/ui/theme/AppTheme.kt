package com.sesi.astralia.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CelestialDarkColorScheme = darkColorScheme(

    // Primary
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryContainer,
    onPrimaryContainer = OnPrimaryContainer,
    inversePrimary = InversePrimary,

    // Secondary
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = SecondaryContainer,
    onSecondaryContainer = OnSecondaryContainer,

    // Tertiary / Gold
    tertiary = Tertiary,
    onTertiary = OnTertiary,
    tertiaryContainer = TertiaryContainer,
    onTertiaryContainer = OnTertiaryContainer,

    // Background
    background = Background,
    onBackground = OnBackground,

    // Surface
    surface = Surface,
    onSurface = OnSurface,

    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurfaceVariant,

    inverseSurface = InverseSurface,
    inverseOnSurface = InverseOnSurface,

    // Outline
    outline = Outline,
    outlineVariant = OutlineVariant,

    // Error
    error = Error,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer,

    // Tint
    surfaceTint = SurfaceTint,
)

private val CelestialLightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,

    primaryContainer = PrimaryFixed,
    onPrimaryContainer = OnPrimaryFixed,

    secondary = Secondary,
    onSecondary = OnSecondary,

    secondaryContainer = SecondaryFixed,
    onSecondaryContainer = OnSecondaryFixed,

    tertiary = Tertiary,
    onTertiary = OnTertiary,

    tertiaryContainer = TertiaryFixed,
    onTertiaryContainer = OnTertiaryFixed,

    background = Color(0xFFF9F7FF),
    onBackground = Color(0xFF1A1B20),

    surface = Color(0xFFF9F7FF),
    onSurface = Color(0xFF1A1B20),

    surfaceVariant = Color(0xFFE5E1EA),
    onSurfaceVariant = Color(0xFF47464E),

    outline = Outline,
    outlineVariant = OutlineVariant,

    error = Error,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer,
)

@Composable
fun CelestialSoulTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> CelestialDarkColorScheme
        else -> CelestialLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = CelestialTypography,
        shapes = CelestialShapes,
        content = content
    )
}