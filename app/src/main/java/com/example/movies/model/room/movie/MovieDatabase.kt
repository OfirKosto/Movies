package com.example.movies.model.room.movie

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movies.model.interfaces.IMovieDao


@Database(entities = [MovieCacheEntity::class], version = 1)
@TypeConverters(GenresConverter::class)
abstract class MovieDatabase: RoomDatabase()  {

    abstract fun movieDao(): IMovieDao

    companion object{
        val DATABASE_NAME: String = "movie_db"
    }

}