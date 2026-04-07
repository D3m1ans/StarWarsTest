package com.n1cks.starwarstest.di

import com.n1cks.starwarstest.root.factory.ComponentFactory
import com.n1cks.starwarstest.root.factory.DefaultComponentFactory
import org.koin.dsl.module

val componentModule = module {
    factory<ComponentFactory> {
        DefaultComponentFactory(
            getPeopleUseCase = get(),
            getPersonDetailsUseCase = get()
        )
    }
}