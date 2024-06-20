package com.lesa.uilogic

import android.icu.text.DecimalFormat
import com.lesa.data.models.AirQuality
import com.lesa.data.models.Astro
import com.lesa.data.models.CurrentWeather
import com.lesa.data.models.Day
import com.lesa.data.models.ForecastDay
import com.lesa.data.models.Hour
import com.lesa.data.models.Location
import com.lesa.data.models.Weather
import com.lesa.uilogic.models.AirQualityUi
import com.lesa.uilogic.models.AstroUi
import com.lesa.uilogic.models.CurrentWeatherUi
import com.lesa.uilogic.models.DayUi
import com.lesa.uilogic.models.ForecastDayUi
import com.lesa.uilogic.models.HourUi
import com.lesa.uilogic.models.LocationUi
import com.lesa.uilogic.models.WeatherUi
import java.text.DateFormat
import java.text.DateFormat.getTimeInstance
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

internal fun Weather.toWeatherUi(): WeatherUi {
    val weatherUi = WeatherUi(
        locationUi = location.toLocationUi(),
        currentWeatherUi = currentWeather.toCurrentWeatherUi(),
        airQualityUi = airQuality.toAirQualityUi(),
        forecastDayUiList = forecast.map {
            it.toForecastUi()
        }
    )
    return weatherUi
}

private fun Location.toLocationUi(): LocationUi {
    return LocationUi(
        name = name,
        region = region,
        country = country,
    )
}

private fun ForecastDay.toForecastUi(): ForecastDayUi {
    return ForecastDayUi(
        date = formatTime(date),
        dayUi = day.toDayUi(),
        astroUi = astro.toAstroUi(),
        hourUiList = hourList.map {
            it.toHourUi()
        }
    )
}

private fun Day.toDayUi(): DayUi {
    return DayUi(
        maxTempC = maxTempC,
        minTempC = minTempC,
        conditionText = conditionText,
        conditionIcon = conditionIcon,
        avgHumidity = avgHumidity,
        maxWindKph = maxWindKph,
        dailyWillItRain = dailyWillItRain,
        dailyWillItSnow = dailyWillItSnow,
        dailyChanceOfRain = dailyChanceOfRain,
        dailyChanceOfSnow = dailyChanceOfSnow,
        totalPrecipMm = totalPrecipMm,
        totalSnowCm = totalSnowCm,
        uv = uv
    )
}

private fun Hour.toHourUi(): HourUi {
    return HourUi(
        time = formatTime(timeEpoch),
        tempC = tempC,
        conditionText = conditionText,
        conditionIcon = conditionIcon,
        windKph = windKph,
        windDir = windDir,
        gustKph = gustKph,
        pressureMmHg = pressureMmHg,
        willItRain = willItRain,
        chanceOfRain = chanceOfRain,
        precipMm = precipMm,
        willItSnow = willItSnow,
        chanceOfSnow = chanceOfSnow,
        snowCm = snowCm,
        humidity = humidity,
        cloud = cloud,
        uv = uv,
        airQuality = airQuality?.toAirQualityUi()
    )
}

internal fun CurrentWeather.toCurrentWeatherUi(): CurrentWeatherUi {
    return CurrentWeatherUi(
        lastUpdated = lastUpdated,
        tempC = tempC,
        conditionText = conditionText,
        conditionIcon = conditionIcon,
        windKph = windKph,
        windDir = windDir,
        pressureMmHg = pressureMmHg.roundToInt(),
        precipMm = precipMm,
        humidity = humidity,
        feelslikeC = feelslikeC,
        uv = uv.roundToInt(),
        gustKph = gustKph,
    )
}

internal fun Astro.toAstroUi(): AstroUi {
    return AstroUi(
        sunriseTime = formatTime(sunriseTime),
        sunsetTime = formatTime(sunsetTime),
        moonriseTime = formatTime(moonriseTime),
        moonsetTime = formatTime(moonsetTime),
        moonPhase = moonPhase,
        moonIllumination = DecimalFormat("#.#").format(moonIllumination),
    )
}

internal fun AirQuality.toAirQualityUi(): AirQualityUi {
    return AirQualityUi(
        co = co,
        no2 = no2,
        o3 = o3,
        so2 = so2,
        pm25 = pm25,
        pm10 = pm10,
    )
}

fun formatTime(date: Date?, locale: Locale = Locale.getDefault()): String {
    val timeFormat = getTimeInstance(DateFormat.SHORT, locale)
    return date?.let { timeFormat.format(date) } ?: ""
}

fun formatTime(date: Long, locale: Locale = Locale.getDefault()): String {
    val timeFormat = getTimeInstance(DateFormat.SHORT, locale)
    return timeFormat.format(date)
}
