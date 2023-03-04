package com.mhmd.weather.domain.models.model

data class WeResponse(
    val city: City? = null,
    val cnt: Int? = null,
    val cod: String? = null,
    val list: List<Data>? = null,
    val message: Int? = null
)