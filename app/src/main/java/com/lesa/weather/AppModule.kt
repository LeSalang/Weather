package com.lesa.weather

import com.lesa.api.WeatherApi
import com.lesa.api.createWeatherApi
import com.lesa.common.AndroidLogcatLogger
import com.lesa.common.Logger
import com.lesa.data.WeatherRepository
import com.lesa.data.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(okHttpClient: OkHttpClient?): WeatherApi {
        return createWeatherApi(
            baseUrl = BuildConfig.WEATHER_API_BASE_URL,
            apiKey = BuildConfig.WEATHER_API_KEY,
            okHttpClient = okHttpClient
        )
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val logging =
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi)
    }

    @Provides
    fun provideLogger(): Logger = AndroidLogcatLogger()
}
