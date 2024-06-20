package com.lesa.uilogic.models

data class AirQualityUi(
    val co: String, // Carbon monoxide level
    val no2: String, // Nitrogen dioxide level
    val o3: String, // Ozone level
    val so2: String, // Sulfur dioxide level
    val pm25: String, // PM2.5 particulate matter level
    val pm10: String, // PM10 particulate matter level
)
