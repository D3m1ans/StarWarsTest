package com.n1cks.starwarstest.core.data.mapper

import com.n1cks.starwarstest.core.data.local.entity.PlanetEntity
import com.n1cks.starwarstest.core.data.remote.dto.PlanetDto
import com.n1cks.starwarstest.core.domain.model.Planet

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