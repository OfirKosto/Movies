package com.example.movies.model.di

import android.content.Context
import androidx.room.Room
import com.example.movies.model.interfaces.IGenreDao
import com.example.movies.model.interfaces.IMovieDao
import com.example.movies.model.room.genre.GenreDatabase
import com.example.movies.model.room.movie.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideGenreDb(@ApplicationContext context: Context): GenreDatabase {
        return Room.databaseBuilder(
            context,
            GenreDatabase::class.java,
            GenreDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideGenreDao(genreDatabase: GenreDatabase): IGenreDao{
        return genreDatabase.genreDao()
    }

    @Singleton
    @Provides
    fun provideMovieDb(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            MovieDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): IMovieDao {
        return movieDatabase.movieDao()
    }
}