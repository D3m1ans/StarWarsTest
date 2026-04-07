package com.n1cks.starwarstest.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.n1cks.starwarstest.root.config.RootConfig
import com.n1cks.starwarstest.root.factory.ComponentFactory

@OptIn(DelicateDecomposeApi::class)
class RootComponentImpl(
    componentContext: ComponentContext,
    private val componentFactory: ComponentFactory
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
            is RootConfig.PeopleList -> {
                RootComponent.Child.PeopleList(
                    componentFactory.createPeopleListComponent(
                        componentContext = childContext,
                        onPersonClick = { id ->
                            navigation.push(RootConfig.PersonDetails(id))
                        }
                    )
                )
            }
            is RootConfig.PersonDetails -> {
                RootComponent.Child.PersonDetails(
                    componentFactory.createPersonDetailsComponent(
                        componentContext = childContext,
                        personId = config.id,
                        onBack = {
                            navigation.pop()
                        }
                    )
                )
            }
        }
}