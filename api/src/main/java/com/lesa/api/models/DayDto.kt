package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayDto(
    @SerialName("maxtemp_c") val maxTempC: Double, // Maximum temperature in Celsius
    @SerialName("maxtemp_f") val maxTempF: Double, // Maximum temperature in Fahrenheit
    @SerialName("mintemp_c") val minTempC: Double, // Minimum temperature in Celsius
    @SerialName("mintemp_f") val minTempF: Double, // Minimum temperature in Fahrenheit
    @SerialName("avgtemp_c") val avgTempC: Double, // Average temperature in Celsius
    @SerialName("avgtemp_f") val avgTempF: Double, // Average temperature in Fahrenheit
    @SerialName("maxwind_mph") val maxWindMph: Double, // Maximum wind speed in miles per hour
    @SerialName("maxwind_kph") val maxWindKph: Double, // Maximum wind speed in kilometers per hour
    @SerialName("totalprecip_mm") val totalPrecipMm: Double, // Total precipitation in millimeters
    @SerialName("totalprecip_in") val totalPrecipIn: Double, // Total precipitation in inches
    @SerialName("totalsnow_cm") val totalSnowCm: Double, // Total snowfall in centimeters
    @SerialName("avgvis_km") val avgVisKm: Double, // Average visibility in kilometers
    @SerialName("avgvis_miles") val avgVisMiles: Double, // Average visibility in miles
    @SerialName("avghumidity") val avgHumidity: Int, // Average humidity as a percentage
    @SerialName("condition") val condition: ConditionDto, // Weather condition
    @SerialName("uv") val uv: Double, // UV index
    @SerialName("daily_will_it_rain") val dailyWillItRain: Int, // Will it rain: 1 = Yes, 0 = No
    @SerialName("daily_chance_of_rain") val dailyChanceOfRain: Int, // Chance of rain as a percentage
    @SerialName("daily_will_it_snow") val dailyWillItSnow: Int, // Will it snow: 1 = Yes, 0 = No
    @SerialName("daily_chance_of_snow") val dailyChanceOfSnow: Int // Chance of snow as a percentage
)
