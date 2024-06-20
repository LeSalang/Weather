package com.lesa.data.models

data class Weather(
    val location: Location,
    val currentWeather: CurrentWeather,
    val airQuality: AirQuality,
    val forecast: List<ForecastDay>,
)
