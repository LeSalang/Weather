package com.lesa.uilogic.models

data class CurrentWeatherUi(
    val lastUpdated: String, // Local time when the real time data was updated
    val tempC: String, // Temperature in Celsius
    val conditionText: String, // Weather condition text
    val conditionIcon: String, // Weather condition icon
    val windKph: String, // Wind speed in kilometers per hour
    val windDir: String, // Wind direction as 16 point compass (e.g., NSW)
    val pressureMmHg: String, // Pressure in mmHg (In * 25.4)
    val precipMm: String, // Precipitation amount in millimeters
    val humidity: String, // Humidity as a percentage
    val feelslikeC: String, // Feels like temperature in Celsius
    val uv: String, // UV Index
    val gustKph: String, // Wind gust in kilometers per hour
)
