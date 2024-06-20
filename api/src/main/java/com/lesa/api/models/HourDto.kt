package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourDto(
    @SerialName("time_epoch") val timeEpoch: Long, // Time as epoch
    @SerialName("time") val time: String, // Date and time
    @SerialName("temp_c") val tempC: Double, // Temperature in Celsius
    @SerialName("temp_f") val tempF: Double, // Temperature in Fahrenheit
    @SerialName("condition") val condition: ConditionDto, // Weather condition
    @SerialName("wind_mph") val windMph: Double, // Wind speed in miles per hour
    @SerialName("wind_kph") val windKph: Double, // Wind speed in kilometers per hour
    @SerialName("wind_degree") val windDegree: Int, // Wind direction in degrees
    @SerialName("wind_dir") val windDir: String, // Wind direction as a compass point
    @SerialName("pressure_mb") val pressureMb: Double, // Pressure in millibars
    @SerialName("pressure_in") val pressureIn: Double, // Pressure in inches
    @SerialName("precip_mm") val precipMm: Double, // Precipitation in millimeters
    @SerialName("precip_in") val precipIn: Double, // Precipitation in inches
    @SerialName("snow_cm") val snowCm: Double? = null, // Snowfall in centimeters
    @SerialName("humidity") val humidity: Int, // Humidity as a percentage
    @SerialName("cloud") val cloud: Int, // Cloud cover as a percentage
    @SerialName("feelslike_c") val feelsLikeC: Double, // Feels like temperature in Celsius
    @SerialName("feelslike_f") val feelsLikeF: Double, // Feels like temperature in Fahrenheit
    @SerialName("windchill_c") val windChillC: Double, // Wind chill temperature in Celsius
    @SerialName("windchill_f") val windChillF: Double, // Wind chill temperature in Fahrenheit
    @SerialName("heatindex_c") val heatIndexC: Double, // Heat index in Celsius
    @SerialName("heatindex_f") val heatIndexF: Double, // Heat index in Fahrenheit
    @SerialName("dewpoint_c") val dewPointC: Double, // Dew point in Celsius
    @SerialName("dewpoint_f") val dewPointF: Double, // Dew point in Fahrenheit
    @SerialName("will_it_rain") val willItRain: Int, // Will it rain: 1 = Yes, 0 = No
    @SerialName("chance_of_rain") val chanceOfRain: Int, // Chance of rain as a percentage
    @SerialName("will_it_snow") val willItSnow: Int, // Will it snow: 1 = Yes, 0 = No
    @SerialName("chance_of_snow") val chanceOfSnow: Int, // Chance of snow as a percentage
    @SerialName("is_day") val isDay: Int, // Is it day: 1 = Yes, 0 = No
    @SerialName("vis_km") val visKm: Double, // Visibility in kilometers
    @SerialName("vis_miles") val visMiles: Double, // Visibility in miles
    @SerialName("gust_mph") val gustMph: Double, // Wind gust speed in miles per hour
    @SerialName("gust_kph") val gustKph: Double, // Wind gust speed in kilometers per hour
    @SerialName("uv") val uv: Double, // UV index
    @SerialName("air_quality") val airQuality: AirQualityDto? = null // Air quality data
)

