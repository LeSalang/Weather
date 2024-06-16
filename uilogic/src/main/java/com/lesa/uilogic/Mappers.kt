package com.lesa.uilogic

import com.lesa.data.models.Astro
import com.lesa.data.models.CurrentWeather
import com.lesa.uilogic.models.AstroUi
import com.lesa.uilogic.models.CurrentWeatherUi
import java.text.DateFormat
import java.text.DateFormat.getTimeInstance
import java.util.Date
import java.util.Locale

internal fun CurrentWeather.toCurrentWeatherUi(): CurrentWeatherUi {
    return CurrentWeatherUi(
        name = name,
        country = country,
        lastUpdated = lastUpdated,
        tempC = tempC,
        conditionText = conditionText,
        conditionIcon = conditionIcon,
        windKph = windKph,
        windDir = windDir,
        pressureMmHg = pressureMmHg,
        precipMm = precipMm,
        humidity = humidity,
        feelslikeC = feelslikeC,
        uv = uv,
        gustKph = gustKph,
        co = co,
        no2 = no2,
        o3 = o3,
        so2 = so2,
        pm25 = pm25,
        pm10 = pm10,
    )
}

internal fun Astro.toAstroUi(): AstroUi {
    return AstroUi(
        sunriseTime = formatTime(sunriseTime),
        sunsetTime = formatTime(sunsetTime),
        moonriseTime = formatTime(moonriseTime),
        moonsetTime = formatTime(moonsetTime),
        moonPhase = moonPhase,
        moonIllumination = moonIllumination
    )
}

fun formatTime(date: Date?, locale: Locale = Locale.getDefault()): String {
    val timeFormat = getTimeInstance(DateFormat.SHORT, locale)
    return timeFormat.format(date)
}
