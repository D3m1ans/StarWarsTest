package com.n1cks.starwarstest.features.peoplelist.state

import com.n1cks.starwarstest.core.domain.model.Person

sealed interface PeopleListState {

    object Loading : PeopleListState

    data class Data(
        val people: List<Person>
    ) : PeopleListState

    object Empty : PeopleListState

    data class Error(
        val message: String
    ) : PeopleListState
}