package com.n1cks.starwarstest.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.n1cks.starwarstest.core.data.local.dao.PeopleDao
import com.n1cks.starwarstest.core.data.local.dao.PlanetDao
import com.n1cks.starwarstest.core.data.local.dao.SpeciesDao
import com.n1cks.starwarstest.core.data.local.entity.PersonEntity
import com.n1cks.starwarstest.core.data.local.entity.PlanetEntity
import com.n1cks.starwarstest.core.data.local.entity.SpeciesEntity

@Database(
    entities = [PersonEntity::class, PlanetEntity::class, SpeciesEntity::class],
    version = 4
)
abstract class AppDB: RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
    abstract fun planetDao(): PlanetDao
    abstract fun speciesDao(): SpeciesDao
}