package com.example.movies.model.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.model.room.genre.GenreCacheEntity

@Dao
interface IGenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genreEntity: GenreCacheEntity): Long

    @Query("SELECT * FROM genres")
    suspend fun getGeneres(): List<GenreCacheEntity>
}