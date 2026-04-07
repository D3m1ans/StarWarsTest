package com.n1cks.starwarstest

import android.app.Application
import com.n1cks.starwarstest.core.data.di.dataModule
import com.n1cks.starwarstest.core.domain.di.domainModule
import com.n1cks.starwarstest.di.componentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(domainModule, dataModule, componentModule)
        }
    }
}