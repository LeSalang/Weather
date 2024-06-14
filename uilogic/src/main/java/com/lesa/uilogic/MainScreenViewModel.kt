package com.lesa.uilogic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesa.common.Logger
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
    private val getCurrentWeatherUseCase: Provider<GetCurrentWeatherUseCase>,
    private val logger: Logger
) : ViewModel() {

    private val _currentWeatherViewState = MutableStateFlow<ViewState>(ViewState.Loading)
    val currentWeatherViewState: StateFlow<ViewState>
        get() = _currentWeatherViewState

    init {
        fetchCurrentWeather()
    }

    @Suppress("TooGenericExceptionCaught")
    private fun fetchCurrentWeather() {
        viewModelScope.launch {
            delay(5000) // TODO remove this after testing loading element
            try {
                _currentWeatherViewState.value = ViewState.Success(getCurrentWeatherUseCase.get().invoke())
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

sealed class ViewState {
    data object Loading : ViewState()
    data class Success(val currentWeather: CurrentWeatherUi) : ViewState()
    data class Error(val errorMessage: String) : ViewState()
}
