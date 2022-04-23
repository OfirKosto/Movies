package com.example.movies.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.room.movie.MovieCacheEntity

@Dao
interface IMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieCacheEntity: MovieCacheEntity): Long

    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<MovieCacheEntity>

}