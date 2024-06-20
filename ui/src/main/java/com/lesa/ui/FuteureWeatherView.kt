package com.lesa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.lesa.uikit.WeatherTheme
import com.lesa.uilogic.models.AstroUi

@Composable
fun FutureWeatherView(
    astroUi: AstroUi,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        WeatherItem(
            text = stringResource(id = R.string.astronomy),
            style = WeatherTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        WeatherItem(
            text = stringResource(id = R.string.sunrise, astroUi.sunriseTime)
        )
        WeatherItem(
            text = stringResource(id = R.string.sunset, astroUi.sunsetTime)
        )
        WeatherItem(
            text = stringResource(id = R.string.moonrise, astroUi.moonriseTime)
        )
        WeatherItem(
            text = stringResource(id = R.string.moonset, astroUi.moonsetTime)
        )
        WeatherItem(
            text = stringResource(id = R.string.moon_phase, astroUi.moonPhase)
        )
        WeatherItem(
            text = stringResource(id = R.string.moon_illumination, astroUi.moonIllumination)
        )
    }
}
