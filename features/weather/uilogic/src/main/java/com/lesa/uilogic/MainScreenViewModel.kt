package com.lesa.uilogic

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import com.lesa.common.Logger
import com.lesa.uilogic.models.WeatherUi
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
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
    private val logger: Logger,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _weatherViewState: MutableStateFlow<ViewState<WeatherUi>> = MutableStateFlow(ViewState.Loading)
    val weatherViewState: StateFlow<ViewState<WeatherUi>>
        get() = _weatherViewState

    var location: MutableStateFlow<String> = MutableStateFlow("Ekaterinburg")

    @Suppress("TooGenericExceptionCaught")
    fun fetchWeather(location: String = this.location.value) {
        viewModelScope.launch {
            try {
                _weatherViewState.value = ViewState.Success(
                    weatherUseCaseProvider.get()
                        .invoke(location = location)
                )
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
    val locationClient = LocationServices.getFusedLocationProviderClient(context)
    var locationInfo = ""

    private val cancellationToken = object : CancellationToken() {
        override fun onCanceledRequested(listener: OnTokenCanceledListener) =
            CancellationTokenSource().token
        override fun isCancellationRequested() = false
    }

    @SuppressLint("MissingPermission")
    fun detectLocation() {
        locationClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY,
            cancellationToken,
        ).addOnSuccessListener {
            locationInfo = "${it.latitude}, ${it.longitude}"
            fetchWeather(location = locationInfo)
        }.addOnFailureListener {
            logger.e("MainScreenViewModel", "Location error: ${it.message}")
        }
    }
}

sealed class ViewState<out T> {
    data object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(val errorMessage: String) : ViewState<Nothing>()
}
