package com.n1cks.starwarstest.core.data.di

import com.n1cks.starwarstest.core.data.repository.PeopleRepositoryImpl
import com.n1cks.starwarstest.core.domain.repository.PeopleRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PeopleRepository> {
        PeopleRepositoryImpl(
            api = get(),
            peopleDao = get(),
            planetDao = get(),
            speciesDao = get(),
            filmDao = get()
        )
    }
}