package com.lesa.data.models

import java.util.Date

data class ForecastDay(
    val date: Date?,
    val day: Day,
    val astro: Astro,
    val hourList: List<Hour>
)
