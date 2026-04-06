package com.n1cks.starwarstest.core.domain.repository

import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.model.PersonDetails

interface PersonRepository {

    suspend fun getPeople(): List<Person>

    suspend fun getPersonDetails(id: Long): PersonDetails
}