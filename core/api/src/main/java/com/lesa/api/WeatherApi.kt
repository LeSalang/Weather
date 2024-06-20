package com.lesa.api

import com.lesa.api.models.AirQualityIndex
import com.lesa.api.models.CurrentWeatherResponseDto
import com.lesa.api.models.WeatherResponseDto
import com.lesa.api.models.astro.AstronomyResponseDto
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

// [API Documentation](https://www.weatherapi.com/docs/#intro-request)
interface WeatherApi {

    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("q") location: String = "Baku", // TODO delete after testing
        @Query("aqi") aqi: String = AirQualityIndex.ENABLED.value,
        @Query("lang") lang: String? = null
    ): CurrentWeatherResponseDto

    @GET("astronomy.json")
    suspend fun getAstronomy(
        @Query("q") location: String = "Baku", // TODO delete after testing
        @Query("lang") lang: String? = null
    ): AstronomyResponseDto

    @GET("forecast.json")
    suspend fun getWeather(
        @Query("q") location: String = "Baku", // TODO delete after testing
        @Query("aqi") aqi: String = AirQualityIndex.ENABLED.value,
        @Query("days") days: Int = 3,
        @Query("lang") lang: String? = null
    ): WeatherResponseDto
}

fun createWeatherApi(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient? = null,
): WeatherApi {
    val json = Json { ignoreUnknownKeys = true }

    return retrofit(
        baseUrl = baseUrl,
        apiKey = apiKey,
        okHttpClient = okHttpClient,
        json = json
    ).create()
}

private fun retrofit(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient?,
    json: Json = Json
): Retrofit {
    val jsonConverter: Converter.Factory = json.asConverterFactory("application/json".toMediaType())

    val modifiedOkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .addInterceptor(WeatherApiKeyInterceptor(apiKey = apiKey))
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverter)
        .client(modifiedOkHttpClient)
        .build()
}
