package com.n1cks.starwarstest.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.n1cks.starwarstest.core.data.local.entity.PersonEntity

@Dao
interface PeopleDao {

    @Query("SELECT * FROM people")
    suspend fun getAll(): List<PersonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<PersonEntity>)
}