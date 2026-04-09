package com.n1cks.starwarstest.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.n1cks.starwarstest.core.data.local.entity.SpeciesEntity

@Dao
interface SpeciesDao {
    @Query("SELECT * FROM species WHERE id = :id")
    suspend fun getById(id: String): SpeciesEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: SpeciesEntity)
}