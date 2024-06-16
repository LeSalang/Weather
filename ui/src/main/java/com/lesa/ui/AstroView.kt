package com.lesa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.lesa.uilogic.ViewState
import com.lesa.uilogic.models.AstroUi

@Composable
fun AstroView(
    astroViewState: ViewState<AstroUi>,
    modifier: Modifier = Modifier
) {
    when (astroViewState) {
        ViewState.Loading -> LoadingView(
            modifier = modifier
        )
        is ViewState.Error -> ErrorView(
            errorMessage = astroViewState.errorMessage
        )
        is ViewState.Success -> AstroSuccessView(
            astroUi = astroViewState.data,
            modifier = modifier
        )
    }
}

@Composable
fun AstroSuccessView(
    astroUi: AstroUi,
    modifier: Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
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
