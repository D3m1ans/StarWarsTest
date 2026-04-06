package com.n1cks.starwarstest.core.domain.usecase

import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.repository.PersonRepository

class GetPeopleUseCase(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(): List<Person> =
        repository.getPeople()
}