package com.lesa.uilogic

import com.lesa.data.WeatherRepository
import com.lesa.uilogic.models.AstroUi
import javax.inject.Inject

internal class GetAstroUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend fun invoke(location: String): AstroUi {
        return repository.getAstro(location = location)
            .toAstroUi()
    }
}
