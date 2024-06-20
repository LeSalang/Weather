package com.lesa.data.models

data class Location(
    val name: String, // Name of the location
    val region: String, // Region of the location
    val country: String, // Country of the location
    val lat: Double, // Latitude of the location
    val lon: Double, // Longitude of the location
    val tzId: String, // Timezone ID of the location
    val localtimeEpoch: Long, // Local time in Unix epoch
    val localtime: String // Local time in string format
)
