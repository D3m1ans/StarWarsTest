package com.n1cks.starwarstest.core.data.di

import org.koin.dsl.module
val dataModule = module {
    includes(networkModule, dataBaseModule, repositoryModule)
}