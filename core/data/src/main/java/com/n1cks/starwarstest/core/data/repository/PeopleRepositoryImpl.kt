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
): PeopleRepository {

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

        val person = peopleDao.getAll().first {it.id == id}.toDomain()
        val cachedPlanet = planetDao.getById(person.homeWorldId)
        val planet = cachedPlanet?.toDomain()
            ?: try {
                val dto = api.getPlanet(person.homeWorldId)
                val entity = dto.toEntity()

                planetDao.insert(entity)
                entity.toDomain()
            } catch (e: Exception) {
                throw e
            }

        return PersonDetails(
            person = person,
            planet = planet
        )
    }

}