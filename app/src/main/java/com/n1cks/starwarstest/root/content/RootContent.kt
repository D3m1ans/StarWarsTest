package com.n1cks.starwarstest.root.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.n1cks.starwarstest.features.peoplelist.ui.PeopleListScreen
import com.n1cks.starwarstest.features.persondetails.ui.PersonDetailsScreen
import com.n1cks.starwarstest.root.component.RootComponent

@Composable
fun RootContent(component: RootComponent) {

    val stack by component.childStack.subscribeAsState()

    Children(
        stack = stack
    ) {
        when(val child = it.instance) {
            is RootComponent.Child.PeopleList ->
                PeopleListScreen(child.component)
            is RootComponent.Child.PersonDetails ->
                PersonDetailsScreen(child.component)
        }
    }
}