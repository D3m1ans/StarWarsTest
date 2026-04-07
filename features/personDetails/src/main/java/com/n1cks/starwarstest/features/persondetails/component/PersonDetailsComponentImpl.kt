package com.n1cks.starwarstest.features.persondetails.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.n1cks.starwarstest.core.domain.usecase.GetPersonDetailsUseCase
import com.n1cks.starwarstest.features.persondetails.state.PersonDetailsState
import com.n1cks.starwarstest.features.shared.componentScope
import kotlinx.coroutines.launch

class PersonDetailsComponentImpl(
    componentContext: ComponentContext,
    private val personId: String,
    private val getPersonDetailsUseCase: GetPersonDetailsUseCase,
    private val onBack: () -> Unit
): PersonDetailsComponent, ComponentContext by componentContext {

    private val _state = MutableValue<PersonDetailsState>(PersonDetailsState.Loading)
    override val state: Value<PersonDetailsState> = _state

    override fun onBackClick() {
        onBack.invoke()
    }

    init {
        loadDetails()
    }

    private fun loadDetails() {
        componentScope().launch {
            _state.value = PersonDetailsState.Loading

            try {
                val details = getPersonDetailsUseCase(personId)

                _state.value = PersonDetailsState.Data(
                    person = details.person,
                    planet = details.planet
                )
            } catch (e: Exception) {
                _state.value = PersonDetailsState.Error(
                    message = e.message ?: "Failed to load details"
                )
            }
        }
    }
}