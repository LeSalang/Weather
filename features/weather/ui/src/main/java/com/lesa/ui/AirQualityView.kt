package com.lesa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.lesa.uilogic.models.AirQualityUi

@Composable
fun AirQualityView(
    airQuality: AirQualityUi,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Heading(
            text = stringResource(id = R.string.air_quality),

        )
        WeatherItem(
            parameter = stringResource(id = R.string.co),
            value = airQuality.co.toString(),
            measure = stringResource(id = R.string.micrograms_per_cubic_metre),
        )
        WeatherItem(
            parameter = stringResource(id = R.string.no2),
            value = airQuality.no2.toString(),
            measure = stringResource(id = R.string.micrograms_per_cubic_metre),
        )
        WeatherItem(
            parameter = stringResource(id = R.string.o3),
            value = airQuality.o3.toString(),
            measure = stringResource(id = R.string.micrograms_per_cubic_metre),
        )
        WeatherItem(
            parameter = stringResource(id = R.string.so2),
            value = airQuality.so2.toString(),
            measure = stringResource(id = R.string.micrograms_per_cubic_metre),
        )
        WeatherItem(
            parameter = stringResource(id = R.string.pm2_5),
            value = airQuality.pm25.toString(),
            measure = stringResource(id = R.string.micrograms_per_cubic_metre),
        )
        WeatherItem(
            parameter = stringResource(id = R.string.pm10),
            value = airQuality.pm10.toString(),
            measure = stringResource(id = R.string.micrograms_per_cubic_metre),
        )
    }
}
