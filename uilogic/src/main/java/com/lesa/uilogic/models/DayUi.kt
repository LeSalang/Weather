package com.lesa.uilogic.models

data class DayUi(
    val maxTempC: Double, // Maximum temperature in Celsius
    val minTempC: Double, // Minimum temperature in Celsius
    val conditionText: String, // Weather condition text
    val maxWindKph: Double, // Maximum wind speed in kilometers per hour
    val dailyWillItRain: Int, // Will it rain: 1 = Yes, 0 = No
    val dailyChanceOfRain: Int, // Chance of rain as a percentage
    val totalPrecipMm: Double, // Total precipitation in millimeters
    val dailyWillItSnow: Int, // Will it snow: 1 = Yes, 0 = No
    val dailyChanceOfSnow: Int, // Chance of snow as a percentage
    val totalSnowCm: Double, // Total snowfall in centimeters
    val avgHumidity: Int, // Average humidity as a percentage
    val conditionIcon: String, // Weather condition icon
    val uv: Double, // UV index
)
