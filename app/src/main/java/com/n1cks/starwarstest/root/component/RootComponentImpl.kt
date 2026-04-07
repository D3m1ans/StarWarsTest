package com.n1cks.starwarstest.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.n1cks.starwarstest.root.config.RootConfig

class RootComponentImpl(
    componentContext: ComponentContext
): RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<RootConfig>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = RootConfig.serializer(),
            initialConfiguration = RootConfig.PeopleList,
            handleBackButton = true,
            childFactory = ::childFactory
        )

    private fun childFactory(
        config: RootConfig,
        childContext: ComponentContext
    ): RootComponent.Child =
        when(config) {
            is RootConfig.PeopleList ->
                TODO()
            is RootConfig.PersonDetails ->
                TODO()
        }
}