package com.n1cks.starwarstest.features.persondetails.component

import com.arkivanov.decompose.ComponentContext
import com.n1cks.starwarstest.core.domain.usecase.GetPersonDetailsUseCase

class PersonDetailsComponentImpl(
    componentContext: ComponentContext,
    private val personId: String,
    private val getPersonDetailsUseCase: GetPersonDetailsUseCase,
    private val onBack: () -> Unit
): PersonDetailsComponent {
}