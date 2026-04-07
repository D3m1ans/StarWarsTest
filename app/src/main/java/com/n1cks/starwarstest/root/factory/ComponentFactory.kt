package com.n1cks.starwarstest.root.factory

import com.arkivanov.decompose.ComponentContext
import com.n1cks.starwarstest.features.peoplelist.component.PeopleListComponent
import com.n1cks.starwarstest.features.persondetails.component.PersonDetailsComponent
import com.n1cks.starwarstest.root.component.RootComponent

interface ComponentFactory {

    fun createRootComponent(componentContext: ComponentContext): RootComponent

    fun createPeopleListComponent(
        componentContext: ComponentContext,
        onPersonClick: (String) -> Unit
    ): PeopleListComponent

    fun createPersonDetailsComponent(
        componentContext: ComponentContext,
        personId: String,
        onBack: () -> Unit
    ): PersonDetailsComponent
}