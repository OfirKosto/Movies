package com.example.movies

import androidx.lifecycle.*
import com.example.movies.model.Genre
import com.example.movies.repositories.GenreRepository
import com.example.movies.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val genreRepository: GenreRepository
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Genre>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Genre>>>
        get() = _dataState

    fun getGenres(){
        viewModelScope.launch {
            genreRepository.getGenre()
                .onEach { dataState ->
                    _dataState.value = dataState
                }
                .launchIn(viewModelScope)
        }
    }
}