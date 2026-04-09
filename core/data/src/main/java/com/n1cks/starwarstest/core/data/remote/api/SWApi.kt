package com.n1cks.starwarstest.core.data.remote.api

import com.n1cks.starwarstest.core.data.remote.dto.PeopleResponseDto
import com.n1cks.starwarstest.core.data.remote.dto.PlanetDto
import com.n1cks.starwarstest.core.data.remote.dto.SpeciesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface SWApi {

    @GET("people/")
    suspend fun getPeople(): PeopleResponseDto

    @GET
    suspend fun getNextPage(@Url url: String): PeopleResponseDto

    @GET("planets/{id}/")
    suspend fun getPlanet(@Path("id") id: String): PlanetDto

    @GET("species/{id}/")
    suspend fun getSpecies(@Path("id") id: String): SpeciesDto
}