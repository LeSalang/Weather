package com.lesa.api.models.astro

import com.lesa.api.models.LocationDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AstronomyResponseDto(
    @SerialName("location") val location: LocationDto,
    @SerialName("astronomy") val astronomy: AstronomyDto
) {
    @Serializable
    data class AstronomyDto(
        @SerialName("astro") val astro: AstroDto
    )
}
