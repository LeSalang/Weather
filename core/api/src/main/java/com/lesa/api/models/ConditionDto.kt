package com.lesa.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConditionDto(
    @SerialName("text") val text: String, // Weather condition text
    @SerialName("icon") val icon: String, // Weather icon URL
    @SerialName("code") val code: Int // Weather condition unique code
)
