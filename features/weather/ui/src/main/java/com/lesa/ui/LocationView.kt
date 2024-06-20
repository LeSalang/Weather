package com.lesa.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.lesa.uikit.WeatherTheme
import com.lesa.uilogic.models.LocationUi

@Composable
fun LocationView(
    locationUi: LocationUi
) {
    WeatherItem(
        text = stringResource(
            id = R.string.location,
            locationUi.name,
            locationUi.country
        ),
        style = WeatherTheme.typography.headlineSmall,
        textAlign = TextAlign.Center,
    )
}
