package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    @SerialName("name") val name: String, // Name of the location
    @SerialName("region") val region: String, // Region of the location
    @SerialName("country") val country: String, // Country of the location
    @SerialName("lat") val lat: Double, // Latitude of the location
    @SerialName("lon") val lon: Double, // Longitude of the location
    @SerialName("tz_id") val tzId: String, // Timezone ID of the location
    @SerialName("localtime_epoch") val localtimeEpoch: Long, // Local time in Unix epoch
    @SerialName("localtime") val localtime: String // Local time in string format
)
