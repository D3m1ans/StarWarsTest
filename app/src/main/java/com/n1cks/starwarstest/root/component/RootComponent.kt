package com.n1cks.starwarstest.root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.n1cks.starwarstest.features.peoplelist.component.PeopleListComponent
import com.n1cks.starwarstest.features.persondetails.component.PersonDetailsComponent

interface RootComponent {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        data class PeopleList(val component: PeopleListComponent): Child()
        data class PersonDetails(val component: PersonDetailsComponent): Child()
    }
}