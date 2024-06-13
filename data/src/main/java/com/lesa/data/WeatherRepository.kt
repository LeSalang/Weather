package com.lesa.data

import com.lesa.api.WeatherApi
import com.lesa.data.models.CurrentWeather
import javax.inject.Inject

interface WeatherRepository {
    suspend fun getCurrentWeather(): CurrentWeather
}

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getCurrentWeather(): CurrentWeather {
        return api.getCurrentWeather()
            .toCurrentWeather()
    }
}
