package com.lesa.data.models

import java.util.Date

data class Astro(
    val sunriseTime: Date?,
    val sunsetTime: Date?,
    val moonriseTime: Date?,
    val moonsetTime: Date?,
    val moonPhase: String,
    val moonIllumination: Double
)
