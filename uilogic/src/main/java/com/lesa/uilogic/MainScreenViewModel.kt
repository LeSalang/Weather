package com.lesa.uilogic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesa.common.Logger
import com.lesa.uilogic.models.AstroUi
import com.lesa.uilogic.models.CurrentWeatherUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.zip.DataFormatException
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class MainScreenViewModel @Inject internal constructor(
    private val currentWeatherUseCaseProvider: Provider<GetCurrentWeatherUseCase>,
    private val astroUseCaseProvider: Provider<GetAstroUseCase>,
    private val logger: Logger
) : ViewModel() {

    private val _currentWeatherViewState: MutableStateFlow<ViewState<CurrentWeatherUi>> =
        MutableStateFlow(ViewState.Loading)
    val currentWeatherViewState: StateFlow<ViewState<CurrentWeatherUi>>
        get() = _currentWeatherViewState

    private val _astroViewState: MutableStateFlow<ViewState<AstroUi>> =
        MutableStateFlow(ViewState.Loading)
    val astroViewState: StateFlow<ViewState<AstroUi>>
        get() = _astroViewState

    init {
        fetchCurrentWeather()
        fetchAstro()
    }

    @Suppress("TooGenericExceptionCaught")
    private fun fetchAstro() {
        viewModelScope.launch {
            try {
                _astroViewState.value = ViewState.Success(astroUseCaseProvider.get().invoke())
            } catch (e: IOException) {
                logger.e("MainScreenViewModel", "Astro network error: ${e.message}")
                _astroViewState.value = ViewState.Error("Network error: ${e.message}")
            } catch (e: DataFormatException) {
                logger.e("MainScreenViewModel", "Astro data format error: ${e.message}")
                _astroViewState.value = ViewState.Error("Data format error: ${e.message}")
            } catch (e: Exception) {
                logger.e("MainScreenViewModel", "Astro unexpected error: ${e.message}")
                _astroViewState.value = ViewState.Error("Unexpected error: ${e.message}")
            }
        }
    }

    @Suppress("TooGenericExceptionCaught")
    private fun fetchCurrentWeather() {
        viewModelScope.launch {
            delay(5000) // TODO remove this after testing loading element
            try {
                _currentWeatherViewState.value = ViewState.Success(currentWeatherUseCaseProvider.get().invoke())
            } catch (e: IOException) {
                logger.e("MainScreenViewModel", "CurrentWeather network error: ${e.message}")
                _currentWeatherViewState.value = ViewState.Error("Network error: ${e.message}")
            } catch (e: DataFormatException) {
                logger.e("MainScreenViewModel", "CurrentWeather data format error: ${e.message}")
                _currentWeatherViewState.value = ViewState.Error("Data format error: ${e.message}")
            } catch (e: Exception) {
                logger.e("MainScreenViewModel", "CurrentWeather unexpected error: ${e.message}")
                _currentWeatherViewState.value = ViewState.Error("Unexpected error: ${e.message}")
            }
        }
    }
}

sealed class ViewState<out T> {
    data object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(val errorMessage: String) : ViewState<Nothing>()
}
