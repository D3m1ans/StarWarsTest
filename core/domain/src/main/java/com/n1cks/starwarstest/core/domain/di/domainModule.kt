package com.n1cks.starwarstest.core.domain.di

import org.koin.dsl.module
val domainModule = module {
    includes(useCaseModule)
}