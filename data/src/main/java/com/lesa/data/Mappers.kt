package com.lesa.data

import com.lesa.api.models.CurrentWeatherResponseDto
import com.lesa.data.models.CurrentWeather

internal fun CurrentWeatherResponseDto.toCurrentWeather(): CurrentWeather {
    val tempC = currentWeather.tempC ?: currentWeather.tempF.let { (it - 32) * 5 / 9 } // TODO improve
    val pressureMmHg = currentWeather.pressureIn * 25.4 // TODO improve

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
