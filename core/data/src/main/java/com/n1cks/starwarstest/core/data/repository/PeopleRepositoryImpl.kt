package com.n1cks.starwarstest.core.data.repository

import com.n1cks.starwarstest.core.data.local.dao.PeopleDao
import com.n1cks.starwarstest.core.data.local.dao.PlanetDao
import com.n1cks.starwarstest.core.data.mapper.toDomain
import com.n1cks.starwarstest.core.data.mapper.toEntity
import com.n1cks.starwarstest.core.data.remote.api.SWApi
import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.model.PersonDetails
import com.n1cks.starwarstest.core.domain.repository.PeopleRepository

class PeopleRepositoryImpl(
    private val api: SWApi,
    private val peopleDao: PeopleDao,
    private val planetDao: PlanetDao,
) : PeopleRepository {

    override suspend fun getPeople(): List<Person> {
        return try {
            val response = api.getPeople()
            val entities = response.results.map { it.toEntity() }
            peopleDao.insertAll(entities)

            entities.map { it.toDomain() }
        } catch (e: Exception) {
            peopleDao.getAll().map { it.toDomain() }
        }
    }

    override suspend fun getPersonDetails(id: String): PersonDetails {
        val personEntity = peopleDao.getAll().firstOrNull { it.id == id }
            ?: throw IllegalStateException("Person not found: $id")

        val person = personEntity.toDomain()

        val planet = planetDao.getById(person.homeWorldId)?.toDomain()
            ?: api.getPlanet(person.homeWorldId).toEntity().also {
                planetDao.insert(it)
            }.toDomain()

        return PersonDetails(person = person, planet = planet)
    }

}