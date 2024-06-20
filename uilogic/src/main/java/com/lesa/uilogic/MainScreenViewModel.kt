package com.lesa.uilogic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesa.common.Logger
import com.lesa.uilogic.models.WeatherUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.zip.DataFormatException
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class MainScreenViewModel @Inject internal constructor(
    private val weatherUseCaseProvider: Provider<GetWeatherUseCase>,
    private val logger: Logger
) : ViewModel() {

    private val _weatherViewState: MutableStateFlow<ViewState<WeatherUi>> = MutableStateFlow(ViewState.Loading)
    val weatherViewState: StateFlow<ViewState<WeatherUi>>
        get() = _weatherViewState

    init {
        fetchWeather()
    }

    @Suppress("TooGenericExceptionCaught")
    private fun fetchWeather() {
        viewModelScope.launch {
            try {
                _weatherViewState.value = ViewState.Success(weatherUseCaseProvider.get().invoke())
            } catch (e: IOException) {
                logger.e("MainScreenViewModel", "Weather network error: ${e.message}")
                _weatherViewState.value = ViewState.Error("Network error: ${e.message}")
            } catch (e: DataFormatException) {
                logger.e("MainScreenViewModel", "Weather data format error: ${e.message}")
                _weatherViewState.value = ViewState.Error("Data format error: ${e.message}")
            } catch (e: Exception) {
                logger.e("MainScreenViewModel", "Weather unexpected error: ${e.message}")
                _weatherViewState.value = ViewState.Error("Unexpected error: ${e.message}")
            }
        }
    }
}

sealed class ViewState<out T> {
    data object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(val errorMessage: String) : ViewState<Nothing>()
}
