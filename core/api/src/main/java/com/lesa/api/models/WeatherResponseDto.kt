package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WeatherResponseDto(
    @SerialName("location") val locationDto: LocationDto,
    @SerialName("current") val currentWeatherDto: CurrentWeatherDto,
    @SerialName("forecast") val forecastDto: ForecastDto,
)
