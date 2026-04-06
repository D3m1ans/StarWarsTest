package com.n1cks.starwarstest.core.domain.usecase

import com.n1cks.starwarstest.core.domain.model.PersonDetails
import com.n1cks.starwarstest.core.domain.repository.PeopleRepository

class GetPersonDetailsUseCase(
    private val repository: PeopleRepository
) {
    suspend operator fun invoke(id: String): PersonDetails =
        repository.getPersonDetails(id = id)
}