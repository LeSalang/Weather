package com.lesa.data.models

data class AirQuality(
    val co: Double, // Carbon monoxide level
    val no2: Double, // Nitrogen dioxide level
    val o3: Double, // Ozone level
    val so2: Double, // Sulfur dioxide level
    val pm25: Double, // PM2.5 particulate matter level
    val pm10: Double, // PM10 particulate matter level
)
