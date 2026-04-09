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