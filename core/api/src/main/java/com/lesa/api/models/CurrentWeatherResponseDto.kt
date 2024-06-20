package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponseDto(
    @SerialName("location") val location: LocationDto, // Information about the location
    @SerialName("current") val currentWeather: CurrentWeatherDto // Current weather details
)
