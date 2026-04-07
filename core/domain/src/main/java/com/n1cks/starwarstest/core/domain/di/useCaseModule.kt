package com.n1cks.starwarstest.core.domain.di

import com.n1cks.starwarstest.core.domain.usecase.GetPeopleUseCase
import com.n1cks.starwarstest.core.domain.usecase.GetPersonDetailsUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory {
        GetPeopleUseCase(repository = get())
    }

    factory {
        GetPersonDetailsUseCase(repository = get())
    }
}