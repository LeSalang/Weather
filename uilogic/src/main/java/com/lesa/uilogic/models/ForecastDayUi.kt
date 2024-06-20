package com.lesa.uilogic.models

data class ForecastDayUi(
    val date: String,
    val dayUi: DayUi,
    val astroUi: AstroUi,
    val hourUiList: List<HourUi>
)
