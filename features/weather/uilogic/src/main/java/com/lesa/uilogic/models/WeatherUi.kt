package com.lesa.uilogic.models

data class WeatherUi(
    val locationUi: LocationUi,
    val currentWeatherUi: CurrentWeatherUi,
    val airQualityUi: AirQualityUi,
    val forecastDayUiList: List<ForecastDayUi>,
)
