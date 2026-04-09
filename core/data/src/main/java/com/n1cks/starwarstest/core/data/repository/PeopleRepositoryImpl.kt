package com.n1cks.starwarstest.core.data.repository

import com.n1cks.starwarstest.core.data.local.dao.FilmDao
import com.n1cks.starwarstest.core.data.local.dao.PeopleDao
import com.n1cks.starwarstest.core.data.local.dao.PlanetDao
import com.n1cks.starwarstest.core.data.local.dao.SpeciesDao
import com.n1cks.starwarstest.core.data.local.entity.PersonEntity
import com.n1cks.starwarstest.core.data.mapper.toDomain
import com.n1cks.starwarstest.core.data.mapper.toEntity
import com.n1cks.starwarstest.core.data.remote.api.SWApi
import com.n1cks.starwarstest.core.domain.model.Film
import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.model.PersonDetails
import com.n1cks.starwarstest.core.domain.model.Planet
import com.n1cks.starwarstest.core.domain.model.Species
import com.n1cks.starwarstest.core.domain.repository.PeopleRepository

class PeopleRepositoryImpl(
    private val api: SWApi,
    private val peopleDao: PeopleDao,
    private val planetDao: PlanetDao,
    private val speciesDao: SpeciesDao,
    private val filmDao: FilmDao
) : PeopleRepository {

    override suspend fun getPeople(): List<Person> {
        return try {
            val allEntities = mutableListOf<PersonEntity>()
            var nextUrl: String? = null

            do {
                val response = if (nextUrl == null) {
                    api.getPeople()
                } else {
                    api.getNextPage(nextUrl)
                }

                val entities = response.results.map { it.toEntity() }
                allEntities.addAll(entities)

                nextUrl = response.next

            } while (nextUrl != null)

            peopleDao.insertAll(allEntities)
            allEntities.map { it.toDomain() }

        } catch (e: Exception) {
            println("Ошибка загрузки: ${e.message}")
            peopleDao.getAll().map { it.toDomain() }
        }
    }

    override suspend fun getPersonDetails(id: String): PersonDetails {
        val personEntity = peopleDao.getById(id)
            ?: throw IllegalStateException("Person not found: $id")

        val person = personEntity.toDomain()
        val planet = loadPlanet(person.homeWorldId)

        val species = loadSpecies(person.speciesIds)
        val films = loadFilms(person.filmsIds)

        return PersonDetails(person, planet, species, films)

    }

    private suspend fun loadPlanet(id: String): Planet {
        return try {
            planetDao.getById(id)?.toDomain()
                ?: api.getPlanet(id).toEntity().also {
                    planetDao.insert(it)
                }.toDomain()
        } catch (e: Exception) {
            planetDao.getById(id)?.toDomain()
                ?: throw e
        }
    }

    private suspend fun loadSpecies(speciesIds: List<String>): List<Species> =
        speciesIds.mapNotNull { id ->
            try {
                speciesDao.getById(id)?.toDomain()
                    ?: api.getSpecies(id).toEntity().also {
                        speciesDao.insert(it)
                    }.toDomain()
            } catch (e: Exception) {
                speciesDao.getById(id)?.toDomain()
            }
        }

    private suspend fun loadFilms(filmIds: List<String>): List<Film> =
        filmIds.mapNotNull { id ->
            try {
                filmDao.getById(id)?.toDomain()
                    ?: api.getFilm(id).toEntity().also {
                        filmDao.insert(it)
                    }.toDomain()
            } catch (e: Exception) {
                filmDao.getById(id)?.toDomain()
            }
        }
}
