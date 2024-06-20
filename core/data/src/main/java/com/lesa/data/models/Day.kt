package com.lesa.data.models

data class Day(
    val maxTempC: Double, // Maximum temperature in Celsius
    val minTempC: Double, // Minimum temperature in Celsius
    val avgTempC: Double, // Average temperature in Celsius
    val maxWindKph: Double, // Maximum wind speed in kilometers per hour
    val totalPrecipMm: Double, // Total precipitation in millimeters
    val totalSnowCm: Double, // Total snowfall in centimeters
    val avgHumidity: Int, // Average humidity as a percentage
    val conditionText: String, // Weather condition text
    val conditionIcon: String, // Weather condition icon
    val uv: Double, // UV index
    val dailyWillItRain: Int, // Will it rain: 1 = Yes, 0 = No
    val dailyChanceOfRain: Int, // Chance of rain as a percentage
    val dailyWillItSnow: Int, // Will it snow: 1 = Yes, 0 = No
    val dailyChanceOfSnow: Int // Chance of snow as a percentage
)
