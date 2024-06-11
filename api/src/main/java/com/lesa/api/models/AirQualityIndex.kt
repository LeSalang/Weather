package com.lesa.api.models

enum class AirQualityIndex(val value: String) {
    ENABLED("yes"),
    DISABLED("no");

    companion object {
        fun fromValue(value: String): AirQualityIndex? {
            return entries.find { it.value == value }
        }
    }
}
