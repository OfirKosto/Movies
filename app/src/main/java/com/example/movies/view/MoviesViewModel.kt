package com.example.movies.view

import androidx.lifecycle.*
import com.example.movies.model.dataclasses.Genre
import com.example.movies.model.dataclasses.Movie
import com.example.movies.model.repositories.GenreRepository
import com.example.movies.model.repositories.MovieRepository
import com.example.movies.model.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val genreRepository: GenreRepository,
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _genreDataState: MutableLiveData<DataState<List<Genre>>> = MutableLiveData()

    val genreDataState: LiveData<DataState<List<Genre>>>
        get() = _genreDataState

    private val _movieDataState: MutableLiveData<DataState<List<Movie>>> = MutableLiveData()

    val movieDataState: LiveData<DataState<List<Movie>>>
        get() = _movieDataState

    fun getGenres(){
        viewModelScope.launch {
            genreRepository.getGenre()
                .onEach { dataState ->
                    _genreDataState.value = dataState
                }
                .launchIn(viewModelScope)
        }
    }

    fun getMovies(){
        viewModelScope.launch {
            movieRepository.getMovie()
                .onEach { dataState ->
                    _movieDataState.value = dataState
                }
                .launchIn(viewModelScope)
        }
    }
}