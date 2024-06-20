package com.lesa.uilogic

import com.lesa.data.WeatherRepository
import com.lesa.uilogic.models.WeatherUi
import javax.inject.Inject

internal class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend fun invoke(): WeatherUi {
        return repository.getWeather()
            .toWeatherUi()
    }
}
