package com.n1cks.starwarstest.core.data.mapper

import com.n1cks.starwarstest.core.data.local.entity.PersonEntity
import com.n1cks.starwarstest.core.data.local.entity.PlanetEntity
import com.n1cks.starwarstest.core.data.remote.dto.PersonDto
import com.n1cks.starwarstest.core.data.remote.dto.PlanetDto
import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.model.Planet

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
        url = url
    )

fun PlanetDto.toEntity(): PlanetEntity =
    PlanetEntity(
        id = extractIdFromUrl(url),
        name = name
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
        homeWorldId = homeWorldId
    )

fun PlanetEntity.toDomain(): Planet =
    Planet(
        id = id,
        name = name
    )

fun extractIdFromUrl(url: String): String {
    return url.trimEnd('/').substringAfterLast('/')
}