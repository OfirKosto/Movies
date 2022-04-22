package com.example.movies.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movies.interfaces.GenreDao

@Database(entities = [GenreCacheEntity::class], version = 1)
abstract class GenreDatabase: RoomDatabase() {

    abstract fun genreDao(): GenreDao

    companion object{
        val DATABASE_NAME: String = "genre_db"
    }
}