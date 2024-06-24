package com.lesa.data

import com.lesa.api.WeatherApi
import com.lesa.data.models.Astro
import com.lesa.data.models.CurrentWeather
import com.lesa.data.models.Weather
import javax.inject.Inject

interface WeatherRepository {
    suspend fun getCurrentWeather(location: String): CurrentWeather

    suspend fun getAstro(location: String): Astro

    suspend fun getWeather(location: String): Weather
}

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getCurrentWeather(location: String): CurrentWeather {
        return api.getCurrentWeather(location = location)
            .currentWeather
            .toCurrentWeather()
    }

    override suspend fun getAstro(location: String): Astro {
        return api.getAstronomy(location = location)
            .toAstro()
    }

    override suspend fun getWeather(location: String): Weather {
        return api.getWeather(location = location)
            .toWeather()
    }
}
