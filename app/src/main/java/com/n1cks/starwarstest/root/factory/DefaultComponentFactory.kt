package com.n1cks.starwarstest.root.factory

import com.arkivanov.decompose.ComponentContext
import com.n1cks.starwarstest.core.domain.usecase.GetPeopleUseCase
import com.n1cks.starwarstest.core.domain.usecase.GetPersonDetailsUseCase
import com.n1cks.starwarstest.features.peoplelist.component.PeopleListComponent
import com.n1cks.starwarstest.features.peoplelist.component.PeopleListComponentImpl
import com.n1cks.starwarstest.features.persondetails.component.PersonDetailsComponent
import com.n1cks.starwarstest.features.persondetails.component.PersonDetailsComponentImpl
import com.n1cks.starwarstest.root.component.RootComponent
import com.n1cks.starwarstest.root.component.RootComponentImpl

class DefaultComponentFactory(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val getPersonDetailsUseCase: GetPersonDetailsUseCase,
) : ComponentFactory {

    override fun createRootComponent(componentContext: ComponentContext): RootComponent =
        RootComponentImpl(
            componentContext = componentContext,
            componentFactory = this
        )

    override fun createPeopleListComponent(
        componentContext: ComponentContext,
        onPersonClick: (String) -> Unit
    ): PeopleListComponent =
        PeopleListComponentImpl(
            componentContext = componentContext,
            getPeopleUseCase = getPeopleUseCase,
            onPersonClick = onPersonClick
        )

    override fun createPersonDetailsComponent(
        componentContext: ComponentContext,
        personId: String,
        onBack: () -> Unit
    ): PersonDetailsComponent =
        PersonDetailsComponentImpl(
            componentContext = componentContext,
            personId = personId,
            getPersonDetailsUseCase = getPersonDetailsUseCase,
            onBack = onBack
        )
}