package com.lesa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.lesa.uikit.Dimensions
import com.lesa.uikit.WeatherTheme
import com.lesa.uilogic.models.CurrentWeatherUi

@Composable
fun CurrentWeatherView(
    modifier: Modifier = Modifier,
    currentWeatherUi: CurrentWeatherUi
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        WeatherItem(
            text = stringResource(id = R.string.last_updated, currentWeatherUi.lastUpdated),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.size(Dimensions.dimen16))
        WeatherItem(
            text = stringResource(id = R.string.temp, currentWeatherUi.tempC),
            style = WeatherTheme.typography.displayLarge,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.size(Dimensions.dimen4))
        WeatherItem(
            text = currentWeatherUi.conditionText,
            style = WeatherTheme.typography.displaySmall,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.size(Dimensions.dimen16))
        Heading(text = stringResource(id = R.string.current_weather))
        WeatherItem(
            parameter = stringResource(id = R.string.wind_speed),
            value = currentWeatherUi.windKph.toString(),
            measure = stringResource(id = R.string.kilometre_per_hour),
        )
        WeatherItem(
            parameter = stringResource(id = R.string.wind_direction),
            value = currentWeatherUi.windDir,
        )
        WeatherItem(
            parameter = stringResource(id = R.string.atmospheric_pressure),
            value = currentWeatherUi.pressureMmHg.toString(),
            measure = stringResource(id = R.string.millimetre_of_mercury),
        )
        WeatherItem(
            parameter = stringResource(id = R.string.uv_index),
            value = currentWeatherUi.uv.toString(),
        )
    }
}
