package com.example.movies.di

import com.example.movies.interfaces.GenreDao
import com.example.movies.interfaces.IGenreApi
import com.example.movies.repositories.GenreRepository
import com.example.movies.retrofit.GenreNetworkMapper
import com.example.movies.room.GenreCacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGenreRepository(
        genreDao: GenreDao,
        genreService: IGenreApi,
        genreCacheMapper: GenreCacheMapper,
        genreNetworkMapper: GenreNetworkMapper,
        apiKey: String
    ): GenreRepository{
        return GenreRepository(genreDao, genreService, genreCacheMapper, genreNetworkMapper, apiKey)
    }
}