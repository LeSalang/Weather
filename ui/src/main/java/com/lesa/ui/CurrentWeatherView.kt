package com.lesa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.lesa.uikit.Dimensions
import com.lesa.uikit.WeatherTheme
import com.lesa.uilogic.ViewState
import com.lesa.uilogic.models.CurrentWeatherUi

@Composable
fun CurrentWeatherView(
    modifier: Modifier = Modifier,
    currentWeatherViewStates: ViewState,
) {
    when (currentWeatherViewStates) {
        ViewState.Loading -> CurrentWeatherLoadingView()
        is ViewState.Error -> CurrentWeatherErrorView(
            errorMessage = currentWeatherViewStates.errorMessage
        )
        is ViewState.Success -> CurrentWeatherSuccessView(
            currentWeatherUi = currentWeatherViewStates.currentWeather,
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
        Text(
            text = stringResource(
                id = R.string.location,
                currentWeatherUi.name,
                currentWeatherUi.country
            ),
            style = WeatherTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Text(
            text = stringResource(id = R.string.last_updated, currentWeatherUi.lastUpdated),
            style = WeatherTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.size(Dimensions.dimen8))
        Text(
            text = stringResource(id = R.string.temp, currentWeatherUi.tempC),
            style = WeatherTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.size(Dimensions.dimen8))
        Text(
            text = currentWeatherUi.conditionText,
            style = WeatherTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Text(
            text = stringResource(id = R.string.wind_speed, currentWeatherUi.windKph, currentWeatherUi.windDir),
            style = WeatherTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Text(
            text = stringResource(id = R.string.atmospheric_pressure, currentWeatherUi.pressureMmHg),
            style = WeatherTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Text(
            text = stringResource(id = R.string.uv_index, currentWeatherUi.uv),
            style = WeatherTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Text(
            text = stringResource(
                id = R.string.aqi,
                currentWeatherUi.co,
                currentWeatherUi.no2,
                currentWeatherUi.o3,
                currentWeatherUi.so2,
                currentWeatherUi.pm25,
                currentWeatherUi.pm10
            ),
            style = WeatherTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
    }
}

@Composable
fun CurrentWeatherErrorView(
    errorMessage: String
) {
    Text(
        text = errorMessage,
        style = WeatherTheme.typography.headlineSmall,
        textAlign = TextAlign.Center,
        color = WeatherTheme.colorScheme.error,
    )
}

@Composable
fun CurrentWeatherLoadingView() {
    CircularProgressIndicator()
}
