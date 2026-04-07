package com.n1cks.starwarstest.features.persondetails.state

import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.model.Planet

sealed interface PersonDetailsState {

    object Loading : PersonDetailsState

    data class Data(
        val person: Person,
        val planet: Planet
    ) : PersonDetailsState

    data class Error(
        val message: String
    ) : PersonDetailsState
}