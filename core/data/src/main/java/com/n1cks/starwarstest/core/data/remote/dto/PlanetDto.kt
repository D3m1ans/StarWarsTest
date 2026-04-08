package com.n1cks.starwarstest.core.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetDto(
    val name: String,
    @SerialName("url") val url: String
)