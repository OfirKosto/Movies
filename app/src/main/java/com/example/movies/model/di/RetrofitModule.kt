package com.example.movies.model.di

import com.example.movies.model.interfaces.IGenreApi
import com.example.movies.model.interfaces.IMovieApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson{
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideGenreService(retrofit: Retrofit.Builder): IGenreApi{
        return retrofit
            .build()
            .create(IGenreApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit.Builder): IMovieApi{
        return retrofit
            .build()
            .create(IMovieApi::class.java)
    }

    @Singleton
    @Provides
    fun provideApiKey(): String{
        return "ab2b5df7c816e21e8300613edd79a926"
    }
}