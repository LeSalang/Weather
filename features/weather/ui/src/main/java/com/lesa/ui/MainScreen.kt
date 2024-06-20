package com.lesa.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lesa.uikit.Dimensions.dimen16
import com.lesa.uikit.Dimensions.dimen8
import com.lesa.uikit.WeatherTheme
import com.lesa.uilogic.MainScreenViewModel
import com.lesa.uilogic.ViewState

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    MainScreen(
        mainScreenViewModel = viewModel(),
        modifier = modifier
    )
}

@Composable
internal fun MainScreen(
    mainScreenViewModel: MainScreenViewModel,
    modifier: Modifier = Modifier,
) {
    val weatherViewState by mainScreenViewModel.weatherViewState.collectAsState()
    when (weatherViewState) {
        ViewState.Loading -> LoadingView()
        is ViewState.Error -> ErrorView(errorMessage = (weatherViewState as ViewState.Error).errorMessage)
        is ViewState.Success -> {
            (weatherViewState as ViewState.Success).data.let { weatherUi ->
                LazyColumn(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(dimen16)
                ) {
                    item {
                        LocationView(locationUi = weatherUi.locationUi,)
                        CurrentWeatherView(currentWeatherUi = weatherUi.currentWeatherUi,)
                        Spacer(modifier = Modifier.size(dimen16))
                        AstroView(astroUi = weatherUi.forecastDayUiList.first().astroUi,)
                        Spacer(modifier = Modifier.size(dimen16))
                        AirQualityView(airQuality = weatherUi.airQualityUi)
                        Spacer(modifier = Modifier.size(dimen16))
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            FutureWeatherBlock()
                            FutureWeatherBlock()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FutureWeatherBlock(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "10.06.2024",
            style = WeatherTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.size(dimen8))
        Text(
            text = "+23 C",
            style = WeatherTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
        Text(
            text = "Partly Cloudy",
            style = WeatherTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.primary,
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    WeatherTheme {
        MainScreen()
    }
}
