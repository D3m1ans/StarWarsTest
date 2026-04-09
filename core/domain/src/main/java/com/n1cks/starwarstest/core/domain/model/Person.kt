package com.n1cks.starwarstest.core.domain.model

data class Person(
    val id: String,
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeWorldId: String,
    val speciesIds: List<String> = emptyList(),
    val filmsIds: List<String> = emptyList()
)