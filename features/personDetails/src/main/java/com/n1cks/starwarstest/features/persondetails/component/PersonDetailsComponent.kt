package com.n1cks.starwarstest.features.persondetails.component

import com.arkivanov.decompose.value.Value
import com.n1cks.starwarstest.features.persondetails.state.PersonDetailsState

interface PersonDetailsComponent {

    val state: Value<PersonDetailsState>

    fun onBackClick()
}