package com.lesa.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.lesa.uikit.Dimensions.dimen8
import com.lesa.uikit.WeatherTheme

@Composable
internal fun WeatherItem(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = WeatherTheme.typography.bodyLarge,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = WeatherTheme.colorScheme.primary,
    textDecoration: TextDecoration? = null,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        style = style,
        textAlign = textAlign,
        textDecoration = textDecoration,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
internal fun WeatherItem(
    parameter: String,
    value: String,
    measure: String = "",
    modifier: Modifier = Modifier,
    style: TextStyle = WeatherTheme.typography.bodyLarge,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = WeatherTheme.colorScheme.primary,
) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(parameter)
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                append(value)
                append(measure)
            }
        },
        style = style,
        textAlign = textAlign,
        color = color,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun Heading(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = WeatherTheme.colorScheme.primary,
) {
    Text(
        text = text,
        color = color,
        style = WeatherTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
        modifier = modifier.fillMaxWidth().padding(bottom = dimen8)
    )
}
