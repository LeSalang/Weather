package com.lesa.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
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

@SuppressLint("MissingPermission")
@Composable
internal fun MainScreen(
    mainScreenViewModel: MainScreenViewModel,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(mainScreenViewModel) {
        mainScreenViewModel.detectLocation()
    }
    var showDialog by remember { mutableStateOf(false) }
    val weatherViewState by mainScreenViewModel.weatherViewState.collectAsState()
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(dimen16),
        modifier = modifier
            .fillMaxSize()
    ) {
        when (weatherViewState) {
            ViewState.Loading -> item { LoadingView() }
            is ViewState.Error -> item {
                ErrorView(errorMessage = (weatherViewState as ViewState.Error).errorMessage)
            }
            is ViewState.Success -> item {
                (weatherViewState as ViewState.Success).data.let { weatherUi ->
                    LocationView(
                        locationUi = weatherUi.locationUi,
                        onSearchClick = {
                            showDialog = it
                        },
                        onGetLocationClick = {
                            mainScreenViewModel.detectLocation()
                        }
                    )
                    CurrentWeatherView(currentWeatherUi = weatherUi.currentWeatherUi)
                    Spacer(modifier = Modifier.size(dimen16))
                    AstroView(astroUi = weatherUi.forecastDayUiList.first().astroUi)
                    Spacer(modifier = Modifier.size(dimen16))
                    AirQualityView(airQuality = weatherUi.airQualityUi)
                    Spacer(modifier = Modifier.size(dimen16))
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        FutureWeatherBlock()
                        FutureWeatherBlock()
                    }
                }
            }
        }
    }
    if (showDialog) {
        LocationDialog(
            mainScreenViewModel = mainScreenViewModel,
            onDismissRequest = { showDialog = false }
        )
    }
}

@Composable
private fun LocationDialog(
    mainScreenViewModel: MainScreenViewModel,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(dimen16)
            ) {
                Text(
                    text = stringResource(R.string.enter_location),
                    style = WeatherTheme.typography.titleMedium,
                    color = WeatherTheme.colorScheme.primary
                )
                TextField(
                    value = mainScreenViewModel.location.collectAsState().value,
                    onValueChange = { newText ->
                        mainScreenViewModel.location.value = newText
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                Spacer(modifier = Modifier.size(dimen16))
                OutlinedButton(
                    onClick = {
                        onDismissRequest()
                        mainScreenViewModel.fetchWeather()
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = stringResource(id = R.string.find_weather).uppercase())
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
