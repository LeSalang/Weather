package com.lesa.uilogic

import com.lesa.data.WeatherRepository
import com.lesa.uilogic.models.WeatherUi
import javax.inject.Inject

internal class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend fun invoke(location: String): WeatherUi {
        return repository.getWeather(location = location)
            .toWeatherUi()
    }
}
