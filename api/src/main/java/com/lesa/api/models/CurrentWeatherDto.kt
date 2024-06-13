package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    @SerialName("last_updated_epoch")
    val lastUpdatedEpoch: Long, // Local time when the real time data was updated in Unix time
    @SerialName("last_updated") val lastUpdated: String, // Local time when the real time data was updated
    @SerialName("temp_c") val tempC: Double? = null, // Temperature in Celsius
    @SerialName("temp_f") val tempF: Double, // Temperature in Fahrenheit
    @SerialName("is_day") val isDay: Int, // Whether to show day condition icon or night icon (1 = Yes, 0 = No)
    @SerialName("condition") val condition: ConditionDto, // Weather condition details
    @SerialName("wind_mph") val windMph: Double, // Wind speed in miles per hour
    @SerialName("wind_kph") val windKph: Double, // Wind speed in kilometers per hour
    @SerialName("wind_degree") val windDegree: Int, // Wind direction in degrees
    @SerialName("wind_dir") val windDir: String, // Wind direction as 16 point compass (e.g., NSW)
    @SerialName("pressure_mb") val pressureMb: Double, // Pressure in millibars
    @SerialName("pressure_in") val pressureIn: Double, // Pressure in inches
    @SerialName("precip_mm") val precipMm: Double, // Precipitation amount in millimeters
    @SerialName("precip_in") val precipIn: Double, // Precipitation amount in inches
    @SerialName("humidity") val humidity: Int, // Humidity as a percentage
    @SerialName("cloud") val cloud: Int, // Cloud cover as a percentage
    @SerialName("feelslike_c") val feelslikeC: Double, // Feels like temperature in Celsius
    @SerialName("feelslike_f") val feelslikeF: Double, // Feels like temperature in Fahrenheit
    @SerialName("vis_km") val visKm: Double, // Visibility in kilometers
    @SerialName("vis_miles") val visMiles: Double, // Visibility in miles
    @SerialName("uv") val uv: Double, // UV Index
    @SerialName("gust_mph") val gustMph: Double, // Wind gust in miles per hour
    @SerialName("gust_kph") val gustKph: Double, // Wind gust in kilometers per hour
    @SerialName("air_quality") val airQuality: AirQualityDto // Air quality details
)
