package com.lesa.uilogic

import com.lesa.data.models.CurrentWeather
import com.lesa.uilogic.models.CurrentWeatherUi

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
