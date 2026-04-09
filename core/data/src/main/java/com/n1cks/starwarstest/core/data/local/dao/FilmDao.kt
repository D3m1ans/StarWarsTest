package com.n1cks.starwarstest.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.n1cks.starwarstest.core.data.local.entity.FilmEntity

@Dao
interface FilmDao {
    @Query("SELECT * FROM films WHERE id = :id")
    suspend fun getById(id: String): FilmEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: FilmEntity)
}