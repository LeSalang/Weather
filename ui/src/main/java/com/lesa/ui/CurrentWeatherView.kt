package com.lesa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.lesa.uikit.Dimensions
import com.lesa.uikit.WeatherTheme
import com.lesa.uilogic.ViewState
import com.lesa.uilogic.models.CurrentWeatherUi

@Composable
fun CurrentWeatherView(
    modifier: Modifier = Modifier,
    currentWeatherViewState: ViewState<CurrentWeatherUi>,
) {
    when (currentWeatherViewState) {
        ViewState.Loading -> LoadingView(
            modifier = modifier
        )
        is ViewState.Error -> ErrorView(
            errorMessage = currentWeatherViewState.errorMessage
        )
        is ViewState.Success -> CurrentWeatherSuccessView(
            currentWeatherUi = currentWeatherViewState.data,
            modifier = modifier
        )
    }
}

@Composable
fun CurrentWeatherSuccessView(
    modifier: Modifier = Modifier,
    currentWeatherUi: CurrentWeatherUi
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        WeatherItem(
            text = stringResource(
                id = R.string.location,
                currentWeatherUi.name,
                currentWeatherUi.country
            ),
            style = WeatherTheme.typography.headlineSmall,
        )
        WeatherItem(
            text = stringResource(id = R.string.last_updated, currentWeatherUi.lastUpdated),
        )
        Spacer(modifier = Modifier.size(Dimensions.dimen8))
        WeatherItem(
            text = stringResource(id = R.string.temp, currentWeatherUi.tempC),
            style = WeatherTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.size(Dimensions.dimen8))
        WeatherItem(
            text = currentWeatherUi.conditionText,
            style = WeatherTheme.typography.titleLarge,
        )
        WeatherItem(
            text = stringResource(id = R.string.wind_speed, currentWeatherUi.windKph, currentWeatherUi.windDir),
        )
        WeatherItem(
            text = stringResource(id = R.string.atmospheric_pressure, currentWeatherUi.pressureMmHg),
        )
        WeatherItem(
            text = stringResource(id = R.string.uv_index, currentWeatherUi.uv),
        )
        WeatherItem(
            text = stringResource(
                id = R.string.aqi,
                currentWeatherUi.co,
                currentWeatherUi.no2,
                currentWeatherUi.o3,
                currentWeatherUi.so2,
                currentWeatherUi.pm25,
                currentWeatherUi.pm10
            ),
        )
    }
}
