package com.n1cks.starwarstest.core.domain.usecase

import com.n1cks.starwarstest.core.domain.model.PersonDetails
import com.n1cks.starwarstest.core.domain.repository.PersonRepository

class GetPersonDetailsUseCase(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(id: Long): PersonDetails =
        repository.getPersonDetails(id = id)
}