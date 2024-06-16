package com.lesa.ui

import androidx.compose.runtime.Composable
import com.lesa.uikit.WeatherTheme

@Composable
fun ErrorView(
    errorMessage: String
) {
    WeatherItem(
        text = errorMessage,
        style = WeatherTheme.typography.headlineSmall,
        color = WeatherTheme.colorScheme.error,
    )
}
