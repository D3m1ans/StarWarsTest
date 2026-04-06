package com.n1cks.starwarstest.core.domain.usecase

import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.repository.PeopleRepository

class GetPeopleUseCase(
    private val repository: PeopleRepository
) {
    suspend operator fun invoke(): List<Person> =
        repository.getPeople()
}