package com.lesa.data

import com.lesa.api.WeatherApi
import com.lesa.data.models.Astro
import com.lesa.data.models.CurrentWeather
import javax.inject.Inject

interface WeatherRepository {
    suspend fun getCurrentWeather(): CurrentWeather

    suspend fun getAstro(): Astro
}

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getCurrentWeather(): CurrentWeather {
        return api.getCurrentWeather()
            .toCurrentWeather()
    }

    override suspend fun getAstro(): Astro {
        return api.getAstronomy()
            .toAstro()
    }
}
