package com.n1cks.starwarstest.core.data.mapper

import com.n1cks.starwarstest.core.data.local.entity.SpeciesEntity
import com.n1cks.starwarstest.core.data.remote.dto.SpeciesDto
import com.n1cks.starwarstest.core.domain.model.Species

fun SpeciesDto.toEntity(): SpeciesEntity =
    SpeciesEntity(id = extractIdFromUrl(url), name = name)

fun SpeciesEntity.toDomain(): Species =
    Species(id = id, name = name)