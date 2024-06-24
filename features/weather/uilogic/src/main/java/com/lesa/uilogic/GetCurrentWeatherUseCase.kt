package com.lesa.uilogic

import com.lesa.data.WeatherRepository
import com.lesa.uilogic.models.CurrentWeatherUi
import javax.inject.Inject

internal class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend fun invoke(location: String): CurrentWeatherUi {
        return repository.getCurrentWeather(location = location)
            .toCurrentWeatherUi()
    }
}
