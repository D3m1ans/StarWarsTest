package com.n1cks.starwarstest.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlanetDto(
    val name: String,
    val climate: String,
    val terrain: String,
    val population: String,
    val url: String
)