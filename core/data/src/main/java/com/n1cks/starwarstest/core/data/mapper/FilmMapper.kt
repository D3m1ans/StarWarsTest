package com.n1cks.starwarstest.core.data.mapper

import com.n1cks.starwarstest.core.data.local.entity.FilmEntity
import com.n1cks.starwarstest.core.data.remote.dto.FilmDto
import com.n1cks.starwarstest.core.domain.model.Film

fun FilmDto.toEntity(): FilmEntity =
    FilmEntity(id = extractIdFromUrl(url), title = title, openingCrawl = openingCrawl)

fun FilmEntity.toDomain(): Film =
    Film(id = id, title = title, openingCrawl = openingCrawl)