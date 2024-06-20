package com.lesa.uilogic.models

data class HourUi(
    val time: String, // Time as epoch
    val tempC: Double, // Temperature in Celsius
    val conditionText: String,
    val conditionIcon: String,
    val windKph: Double, // Wind speed in kilometers per hour
    val windDir: String, // Wind direction as a compass point
    val gustKph: Double, // Wind gust speed in kilometers per hour
    val pressureMmHg: Double, // Pressure in mmHg
    val willItRain: Int, // Will it rain: 1 = Yes, 0 = No
    val chanceOfRain: Int, // Chance of rain as a percentage
    val precipMm: Double, // Precipitation in millimeters
    val willItSnow: Int, // Will it snow: 1 = Yes, 0 = No
    val chanceOfSnow: Int, // Chance of snow as a percentage
    val snowCm: Double?, // Snowfall in centimeters
    val humidity: Int, // Humidity as a percentage
    val cloud: Int, // Cloud cover as a percentage
    val uv: Double, // UV index
    val airQuality: AirQualityUi? // Air quality data
)
