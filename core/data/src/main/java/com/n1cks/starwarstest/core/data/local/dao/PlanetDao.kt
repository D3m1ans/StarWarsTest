package com.n1cks.starwarstest.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.n1cks.starwarstest.core.data.local.entity.PlanetEntity

@Dao
interface PlanetDao {
    @Query("SELECT * FROM planets WHERE id = :id")
    suspend fun getById(id: String): PlanetEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PlanetEntity)
}