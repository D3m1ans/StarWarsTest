package com.n1cks.starwarstest.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.n1cks.starwarstest.core.data.local.dao.PeopleDao
import com.n1cks.starwarstest.core.data.local.dao.PlanetDao
import com.n1cks.starwarstest.core.data.local.entity.PersonEntity
import com.n1cks.starwarstest.core.data.local.entity.PlanetEntity

@Database(
    entities = [PersonEntity::class, PlanetEntity::class],
    version = 2
)
abstract class AppDB: RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
    abstract fun planetDao(): PlanetDao
}