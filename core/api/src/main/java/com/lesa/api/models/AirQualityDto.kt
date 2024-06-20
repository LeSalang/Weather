package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirQualityDto(
    @SerialName("co") val co: Double, // Carbon monoxide level
    @SerialName("no2") val no2: Double, // Nitrogen dioxide level
    @SerialName("o3") val o3: Double, // Ozone level
    @SerialName("so2") val so2: Double, // Sulfur dioxide level
    @SerialName("pm2_5") val pm25: Double, // PM2.5 particulate matter level
    @SerialName("pm10") val pm10: Double, // PM10 particulate matter level
    @SerialName("us-epa-index") val usEpaIndex: Int, // US EPA air quality index
    @SerialName("gb-defra-index") val gbDefraIndex: Int // UK DEFRA air quality index
)
