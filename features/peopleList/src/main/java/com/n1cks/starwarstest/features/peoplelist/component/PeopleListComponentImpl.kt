package com.n1cks.starwarstest.features.peoplelist.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.core.domain.usecase.GetPeopleUseCase
import com.n1cks.starwarstest.features.peoplelist.state.PeopleListState
import com.n1cks.starwarstest.features.shared.scope.componentScope
import kotlinx.coroutines.launch

class PeopleListComponentImpl(
    componentContext: ComponentContext,
    private val getPeopleUseCase: GetPeopleUseCase,
    private val onPersonClick: (String) -> Unit
) : PeopleListComponent, ComponentContext by componentContext {

    private val _state = MutableValue<PeopleListState>(PeopleListState.Loading)
    override val state: Value<PeopleListState> = _state

    private var allPeopleCache: List<Person> = emptyList()

    override fun onPersonClick(id: String) {
        onPersonClick.invoke(id)
    }

    override fun onSearchQueryChanged(query: String) {
        val filtered = if (query.isBlank()) {
            allPeopleCache
        } else {
            allPeopleCache.filter { person ->
                person.name.contains(query, ignoreCase = true)
            }
        }
        _state.value = PeopleListState.Data(
            allPeople = allPeopleCache,
            filteredPeople = filtered
        )
    }

    init {
        loadPeople()
    }

    private fun loadPeople() {
        componentScope().launch {
            _state.value = PeopleListState.Loading
            try {
                val people = getPeopleUseCase()
                allPeopleCache = people
                _state.value = if (people.isEmpty()) {
                    PeopleListState.Empty
                } else {
                    PeopleListState.Data(
                        allPeople = people,
                        filteredPeople = people
                    )
                }
            } catch (e: Exception) {
                _state.value = PeopleListState.Error(
                    message = e.message ?: "Unknown error"
                )
            }
        }
    }
}