package com.sesi.astralia.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import astralia.shared.generated.resources.Res
import astralia.shared.generated.resources.manrope_regular
import astralia.shared.generated.resources.manrope_semibold
import astralia.shared.generated.resources.playfair_display_bold
import astralia.shared.generated.resources.playfair_display_regular
import astralia.shared.generated.resources.playfair_display_semibold
import org.jetbrains.compose.resources.Font

val PlayfairDisplay: FontFamily
    @Composable
    get() = FontFamily(
        Font(
            resource = Res.font.playfair_display_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resource = Res.font.playfair_display_semibold,
            weight = FontWeight.SemiBold
        ),
        Font(
            resource = Res.font.playfair_display_bold,
            weight = FontWeight.Bold
        )
    )

val Manrope: FontFamily
    @Composable
    get() = FontFamily(
        Font(
            resource = Res.font.manrope_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resource = Res.font.manrope_semibold,
            weight = FontWeight.SemiBold
        )
    )

val CelestialTypography: Typography
    @Composable
    get() = Typography(

        // Playfair Display
        displayLarge = TextStyle(
            fontFamily = PlayfairDisplay,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            lineHeight = 48.sp,
            letterSpacing = (-0.02).sp
        ),

        displayMedium = TextStyle(
            fontFamily = PlayfairDisplay,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = (-0.01).sp
        ),

        headlineMedium = TextStyle(
            fontFamily = PlayfairDisplay,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 32.sp
        ),

        // Manrope
        bodyLarge = TextStyle(
            fontFamily = Manrope,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 28.sp
        ),

        bodyMedium = TextStyle(
            fontFamily = Manrope,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),

        labelMedium = TextStyle(
            fontFamily = Manrope,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.7.sp
        ),

        // Mobile headline
        headlineLarge = TextStyle(
            fontFamily = PlayfairDisplay,
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            lineHeight = 36.sp
        )
    )
