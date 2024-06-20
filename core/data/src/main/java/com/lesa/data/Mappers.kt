package com.lesa.data

import com.lesa.api.models.AirQualityDto
import com.lesa.api.models.CurrentWeatherDto
import com.lesa.api.models.DayDto
import com.lesa.api.models.ForecastDto
import com.lesa.api.models.HourDto
import com.lesa.api.models.LocationDto
import com.lesa.api.models.WeatherResponseDto
import com.lesa.api.models.astro.AstroDto
import com.lesa.api.models.astro.AstronomyResponseDto
import com.lesa.data.models.AirQuality
import com.lesa.data.models.Astro
import com.lesa.data.models.CurrentWeather
import com.lesa.data.models.Day
import com.lesa.data.models.ForecastDay
import com.lesa.data.models.Hour
import com.lesa.data.models.Location
import com.lesa.data.models.Weather
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val FAHRENHEIT_TO_CELSIUS_SCALE = 5.0 / 9.0
private const val FAHRENHEIT_TO_CELSIUS_OFFSET = 32
private const val INCHES_TO_MM_SCALE = 25.4

internal fun WeatherResponseDto.toWeather(): Weather {
    return Weather(
        location = locationDto.toLocation(),
        currentWeather = currentWeatherDto.toCurrentWeather(),
        forecast = forecastDto.toForecast(),
        airQuality = currentWeatherDto.airQualityDto.toAirQuality(),
    )
}

internal fun ForecastDto.toForecast(): List<ForecastDay> {
    val forecastDayList: MutableList<ForecastDay> = mutableListOf()
    forecastDayDtoList.forEach { forecastDayDto ->
        val forecastDay = ForecastDay(
            date = parseDate(forecastDayDto.date),
            day = forecastDayDto.dayDto.toDay(),
            astro = forecastDayDto.astroDto.toAstro(),
            hourList = forecastDayDto.hourDtoList.map { hourDto ->
                hourDto.toHour()
            }
        )
        forecastDayList.add(forecastDay)
    }
    return forecastDayList
}

internal fun CurrentWeatherDto.toCurrentWeather(): CurrentWeather {
    val tempC = tempC ?: tempF.let {
        (it - FAHRENHEIT_TO_CELSIUS_OFFSET) * FAHRENHEIT_TO_CELSIUS_SCALE
    }

    return CurrentWeather(
        lastUpdated = lastUpdated,
        tempC = tempC,
        conditionText = condition.text,
        conditionIcon = condition.icon,
        windKph = windKph,
        windDir = windDir,
        pressureMmHg = convertPreassureInToMmHg(pressureIn),
        precipMm = precipMm,
        humidity = humidity,
        feelslikeC = feelslikeC,
        uv = uv,
        gustKph = gustKph,
    )
}

internal fun AstronomyResponseDto.toAstro(): Astro {
    val astro = astronomy.astro
    return astro.toAstro()
}

internal fun AirQualityDto.toAirQuality(): AirQuality {
    return AirQuality(
        co = co,
        no2 = no2,
        o3 = o3,
        so2 = so2,
        pm25 = pm25,
        pm10 = pm10
    )
}

internal fun AstroDto.toAstro(): Astro {
    return Astro(
        sunriseTime = parseDate(sunriseTime),
        sunsetTime = parseDate(sunsetTime),
        moonriseTime = parseDate(moonriseTime),
        moonsetTime = parseDate(moonsetTime),
        moonPhase = moonPhase,
        moonIllumination = moonIllumination
    )
}

internal fun DayDto.toDay(): Day {
    return Day(
        maxTempC = maxTempC,
        minTempC = minTempC,
        avgTempC = avgTempC,
        maxWindKph = maxWindKph,
        totalPrecipMm = totalPrecipMm,
        totalSnowCm = totalSnowCm,
        avgHumidity = avgHumidity,
        conditionText = condition.text,
        conditionIcon = condition.icon,
        uv = uv,
        dailyWillItRain = dailyWillItRain,
        dailyChanceOfRain = dailyChanceOfRain,
        dailyWillItSnow = dailyWillItSnow,
        dailyChanceOfSnow = dailyChanceOfSnow
    )
}

internal fun HourDto.toHour(): Hour {
    return Hour(
        timeEpoch = timeEpoch,
        tempC = tempC,
        conditionText = condition.text,
        conditionIcon = condition.icon,
        windKph = windKph,
        windDir = windDir,
        pressureMmHg = convertPreassureInToMmHg(pressureIn),
        precipMm = precipMm,
        snowCm = snowCm,
        humidity = humidity,
        cloud = cloud,
        willItRain = willItRain,
        chanceOfRain = chanceOfRain,
        willItSnow = willItSnow,
        chanceOfSnow = chanceOfSnow,
        visKm = visKm,
        gustKph = gustKph,
        uv = uv,
        airQuality = airQuality?.toAirQuality(),
    )
}

internal fun LocationDto.toLocation(): Location {
    return Location(
        name = name,
        country = country,
        region = region,
        lat = lat,
        lon = lon,
        tzId = tzId,
        localtimeEpoch = localtimeEpoch,
        localtime = localtime
    )
}

@Suppress("PrintStackTrace")
private fun parseDate(dateString: String): Date? {
    val dateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return try {
        dateFormat.parse(dateString)
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }
}

private fun convertPreassureInToMmHg(pressureIn: Double): Double {
    return pressureIn * INCHES_TO_MM_SCALE
}
