package com.lesa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.lesa.uilogic.models.AstroUi

@Composable
fun AstroView(
    astroUi: AstroUi,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Heading(
            text = stringResource(id = R.string.astronomy),
        )
        WeatherItem(
            parameter = stringResource(id = R.string.sunrise),
            value = astroUi.sunriseTime
        )
        WeatherItem(
            parameter = stringResource(id = R.string.sunset),
            value = astroUi.sunsetTime
        )
        WeatherItem(
            parameter = stringResource(id = R.string.moonrise),
            value = astroUi.moonriseTime
        )
        WeatherItem(
            parameter = stringResource(id = R.string.moonset),
            value = astroUi.moonsetTime
        )
        WeatherItem(
            parameter = stringResource(id = R.string.moon_phase),
            value = astroUi.moonPhase
        )
        WeatherItem(
            parameter = stringResource(id = R.string.moon_illumination),
            value = astroUi.moonIllumination,
            measure = stringResource(id = R.string.percent)
        )
    }
}
