package com.lesa.api.models

import com.lesa.api.models.astro.AstroDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastDayDto(
    @SerialName("date") val date: String,
    @SerialName("date_epoch") val dateEpoch: Long,
    @SerialName("day") val dayDto: DayDto,
    @SerialName("astro") val astroDto: AstroDto,
    @SerialName("hour") val hourDtoList: List<HourDto>
)
