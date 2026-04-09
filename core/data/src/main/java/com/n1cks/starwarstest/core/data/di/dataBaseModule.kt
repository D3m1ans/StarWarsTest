package com.n1cks.starwarstest.core.data.di

import androidx.room.Room
import com.n1cks.starwarstest.core.data.local.db.AppDB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDB::class.java,
            "app_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDB>().peopleDao() }
    single { get<AppDB>().planetDao() }
    single { get<AppDB>().speciesDao() }
}