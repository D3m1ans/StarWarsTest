package com.n1cks.starwarstest.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PeopleResponseDto(
    val next: String? = null,
    val results: List<PersonDto>
)
