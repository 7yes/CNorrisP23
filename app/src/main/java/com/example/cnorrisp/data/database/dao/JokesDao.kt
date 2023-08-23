package com.example.cnorrisp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cnorrisp.data.database.entities.ChuckEntity

@Dao
interface JokesDao {

    @Query("SELECT * FROM jokes_table ORDER BY id DESC ")
    suspend fun getAllJokes():List<ChuckEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertALl(jokes:List<ChuckEntity>)

    @Query("DELETE FROM jokes_table") // no olv el where
    suspend fun deleteAll()
}