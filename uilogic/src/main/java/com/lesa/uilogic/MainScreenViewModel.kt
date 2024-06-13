package com.lesa.uilogic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesa.uilogic.models.CurrentWeatherUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class MainScreenViewModel @Inject internal constructor(
    private val getCurrentWeatherUseCase: Provider<GetCurrentWeatherUseCase>
) : ViewModel() {

    private val _currentWeather = MutableStateFlow<CurrentWeatherUi?>(null)
    val currentWeather: StateFlow<CurrentWeatherUi?>
        get() = _currentWeather

    init {
        fetchCurrentWeather()
    }

    private fun fetchCurrentWeather() {
        viewModelScope.launch {
            try {
                _currentWeather.value = getCurrentWeatherUseCase.get().invoke()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
