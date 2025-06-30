package com.atech.financialapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = primaryLight,
    surface = surfaceLight,
    onSurfaceVariant = onSurfaceVariantLight,
    onSurface = onSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    outline = outlineLight,
    surfaceTint = surfaceTintLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceDim = surfaceDimLight,
    primaryContainer = primaryContainerLight,
    inverseSurface = inverseSurfaceLight,
    secondaryContainer = secondaryContainerLight,
    onSecondary = onSecondaryLight,
    tertiaryContainer = tertiaryContainerLight,
)

private val DarkColorScheme = darkColorScheme(
    primary = primaryDark,
    surface = surfaceDark,
    onSurfaceVariant = onSurfaceVariantDark,
    onSurface = onSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    outline = outlineDark,
    surfaceTint = surfaceTintDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceDim = surfaceDimDark,
    primaryContainer = primaryContainerDark,
    inverseSurface = inverseSurfaceDark,
    secondaryContainer = secondaryContainerDark,
    onSecondary = onSecondaryDark,
    tertiaryContainer = tertiaryContainerDark,
)

@Composable
fun FinancialAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}