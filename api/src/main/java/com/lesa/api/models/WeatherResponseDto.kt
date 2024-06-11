package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDto(
    @SerialName("location") val location: LocationDto, // Information about the location
    @SerialName("current") val current: CurrentDto // Current weather details
)
