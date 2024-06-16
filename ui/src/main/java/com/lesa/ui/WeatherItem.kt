package com.lesa.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.lesa.uikit.WeatherTheme

@Composable
internal fun WeatherItem(
    text: String,
    style: TextStyle = WeatherTheme.typography.bodyLarge,
    textAlign: TextAlign = TextAlign.Center,
    color: androidx.compose.ui.graphics.Color = WeatherTheme.colorScheme.primary
) {
    Text(
        text = text,
        style = style,
        textAlign = textAlign,
        color = color,
    )
}
