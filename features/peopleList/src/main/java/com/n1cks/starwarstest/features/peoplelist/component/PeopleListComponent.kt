package com.n1cks.starwarstest.features.peoplelist.component

import com.arkivanov.decompose.value.Value
import com.n1cks.starwarstest.features.peoplelist.state.PeopleListState

interface PeopleListComponent {
    val state: Value<PeopleListState>
    fun onPersonClick(id: String)
    fun onSearchQueryChanged(query: String)
}