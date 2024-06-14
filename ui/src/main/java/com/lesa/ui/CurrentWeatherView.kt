package com.lesa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
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
        ViewState.Loading -> CurrentWeatherLoadingView(
            modifier = modifier
        )
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

@Composable
fun CurrentWeatherErrorView(
    errorMessage: String
) {
    WeatherItem(
        text = errorMessage,
        style = WeatherTheme.typography.headlineSmall,
        color = WeatherTheme.colorScheme.error,
    )
}

@Composable
fun CurrentWeatherLoadingView(
    modifier: Modifier = Modifier,
) {
    val weatherLoadingLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.sun_loading
        )
    )

    val loadingProgress by animateLottieCompositionAsState(
        weatherLoadingLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    LottieAnimation(
        composition = weatherLoadingLottieComposition,
        progress = loadingProgress,
        modifier = modifier
    )
}

@Composable
private fun WeatherItem(
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
