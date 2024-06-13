package com.lesa.uilogic

import com.lesa.data.WeatherRepository
import com.lesa.data.WeatherRepositoryImpl
import com.lesa.uilogic.models.CurrentWeatherUi
import javax.inject.Inject

internal class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend fun invoke(): CurrentWeatherUi {
        return repository.getCurrentWeather()
            .toCurrentWeatherUi()
    }
}
