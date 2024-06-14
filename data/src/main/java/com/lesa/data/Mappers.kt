package com.lesa.data

import com.lesa.api.models.CurrentWeatherResponseDto
import com.lesa.data.models.CurrentWeather

private const val FAHRENHEIT_TO_CELSIUS_SCALE = 5.0 / 9.0
private const val FAHRENHEIT_TO_CELSIUS_OFFSET = 32
private const val INCHES_TO_MM_SCALE = 25.4

internal fun CurrentWeatherResponseDto.toCurrentWeather(): CurrentWeather {
    val tempC = currentWeather.tempC ?: currentWeather.tempF.let {
        (it - FAHRENHEIT_TO_CELSIUS_OFFSET) * FAHRENHEIT_TO_CELSIUS_SCALE
    }

    val pressureMmHg = currentWeather.pressureIn * INCHES_TO_MM_SCALE

    return CurrentWeather(
        name = location.name,
        country = location.country,
        lastUpdated = currentWeather.lastUpdated,
        tempC = tempC,
        conditionText = currentWeather.condition.text,
        conditionIcon = currentWeather.condition.icon,
        windKph = currentWeather.windKph,
        windDir = currentWeather.windDir,
        pressureMmHg = pressureMmHg,
        precipMm = currentWeather.precipMm,
        humidity = currentWeather.humidity,
        feelslikeC = currentWeather.feelslikeC,
        uv = currentWeather.uv,
        gustKph = currentWeather.gustKph,
        co = currentWeather.airQuality.co,
        no2 = currentWeather.airQuality.no2,
        o3 = currentWeather.airQuality.o3,
        so2 = currentWeather.airQuality.so2,
        pm25 = currentWeather.airQuality.pm25,
        pm10 = currentWeather.airQuality.pm10
    )
}
