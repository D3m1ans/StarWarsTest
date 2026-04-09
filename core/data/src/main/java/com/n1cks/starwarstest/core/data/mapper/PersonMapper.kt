package com.n1cks.starwarstest.core.data.mapper

import com.n1cks.starwarstest.core.data.local.entity.PersonEntity
import com.n1cks.starwarstest.core.data.remote.dto.PersonDto
import com.n1cks.starwarstest.core.domain.model.Person

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
        filmsIds = films.joinToString(",") { extractIdFromUrl(it) },
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
        speciesIds = speciesIds.parseIds(),
        filmsIds = filmsIds.parseIds()
    )

fun String.parseIds(): List<String> =
    if (isBlank()) emptyList() else split(",").map { it.trim() }