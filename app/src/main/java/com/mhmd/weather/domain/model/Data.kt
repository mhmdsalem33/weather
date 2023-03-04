package com.mhmd.weather.domain.models.model

data class Data(
    val clouds: Clouds? = null,
    val dt: Int? = null,
    val dt_txt: String? = null,
    val main: Main? = null,
    val pop: Int? = null,
    val sys: Sys? = null,
    val visibility: Int? = null,
    val weather: List<Weather>? = null,
    val wind: Wind? = null
)