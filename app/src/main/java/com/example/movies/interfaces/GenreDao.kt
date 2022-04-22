package com.example.movies.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.room.GenreCacheEntity

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genreEntity: GenreCacheEntity): Long

    @Query("SELECT * FROM genres")
    suspend fun getGeneres(): List<GenreCacheEntity>
}