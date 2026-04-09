package com.n1cks.starwarstest.core.data.mapper

import com.n1cks.starwarstest.core.data.local.entity.PersonEntity
import com.n1cks.starwarstest.core.data.local.entity.PlanetEntity
import com.n1cks.starwarstest.core.data.local.entity.SpeciesEntity
import com.n1cks.starwarstest.core.data.remote.dto.PersonDto
import com.n1cks.starwarstest.core.data.remote.dto.PlanetDto
import com.n1cks.starwarstest.core.data.remote.dto.SpeciesDto
import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.model.Planet
import com.n1cks.starwarstest.core.domain.model.Species

fun PersonDto.toEntity(): PersonEntity =
    PersonEntity(
        id = extractIdFromUrl(url),
        name = name,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        birthYear = birthYear,
        gender = gender,
        homeWorldId = extractIdFromUrl(homeWorld),
        speciesIds = species.joinToString(",") { extractIdFromUrl(it) },
        url = url
    )

fun PersonEntity.toDomain(): Person =
    Person(
        id = id,
        name = name,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        birthYear = birthYear,
        gender = gender,
        homeWorldId = homeWorldId,
        speciesIds = if (speciesIds.isBlank()) emptyList()
        else speciesIds.split(",").map { it.trim() }
    )

fun PlanetDto.toEntity(): PlanetEntity =
    PlanetEntity(
        id = extractIdFromUrl(url),
        name = name,
        climate = climate,
        terrain = terrain,
        population = population
    )

fun PlanetEntity.toDomain(): Planet =
    Planet(
        id = id,
        name = name,
        climate = climate,
        terrain = terrain,
        population = population
    )

fun SpeciesDto.toEntity(): SpeciesEntity =
    SpeciesEntity(id = extractIdFromUrl(url), name = name)

fun SpeciesEntity.toDomain(): Species =
    Species(id = id, name = name)

fun extractIdFromUrl(url: String): String {
    return url.trimEnd('/').substringAfterLast('/')
}