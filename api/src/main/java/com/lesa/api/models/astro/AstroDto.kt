package com.lesa.api.models.astro

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AstroDto(
    @SerialName("sunrise") val sunriseTime: String,
    @SerialName("sunset") val sunsetTime: String,
    @SerialName("moonrise") val moonriseTime: String,
    @SerialName("moonset") val moonsetTime: String,
    @SerialName("moon_phase") val moonPhase: String,
    @SerialName("moon_illumination") val moonIllumination: Double
)
