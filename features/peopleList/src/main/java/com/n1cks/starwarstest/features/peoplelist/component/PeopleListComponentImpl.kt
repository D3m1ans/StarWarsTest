package com.n1cks.starwarstest.features.peoplelist.component

import com.arkivanov.decompose.ComponentContext
import com.n1cks.starwarstest.core.domain.usecase.GetPeopleUseCase

class PeopleListComponentImpl(
    componentContext: ComponentContext,
    private val getPeopleUseCase: GetPeopleUseCase,
    private val onPersonClick: (String) -> Unit
): PeopleListComponent {
}