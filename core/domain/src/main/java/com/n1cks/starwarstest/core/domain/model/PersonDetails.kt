package com.n1cks.starwarstest.core.domain.model

data class PersonDetails(
    val person: Person,
    val planet: Planet,
    val species: List<Species>,
    val films: List<Film>
)