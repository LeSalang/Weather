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
                id = com.lesa.uilogic.R.string.location,
                currentWeatherUi.name,
                currentWeatherUi.country
            ),
            style = WeatherTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Text(
            text = stringResource(id = com.lesa.uilogic.R.string.lust_updated, currentWeatherUi.lastUpdated),
            style = WeatherTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.size(Dimensions.dimen8))
        Text(
            text = stringResource(id = com.lesa.uilogic.R.string.temp, currentWeatherUi.tempC),
            style = WeatherTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Text(
            text = currentWeatherUi.conditionText,
            style = WeatherTheme.typography.titleLarge,
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
