package com.zai.movieku.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zai.movieku.network.Movie
import com.zai.movieku.network.MoviesApi
import kotlinx.coroutines.launch

enum class MoviesApiStatus { LOADING, ERROR, DONE }

class MoviesViewModel: ViewModel(){

    private val _status = MutableLiveData<MoviesApiStatus>()
    val status: LiveData<MoviesApiStatus> = _status

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun listToString(list: List<String>): String {
        return list.joinToString("\n")
    }

    fun getMovieList() {
        viewModelScope.launch {
            _status.value = MoviesApiStatus.LOADING
            try {
                _movies.value = MoviesApi.retrofitService.getMovies().await().results
                _status.value = MoviesApiStatus.DONE
            } catch (e: Exception) {
                _movies.value = listOf()
                _status.value = MoviesApiStatus.ERROR
            }
        }
    }

    fun onMovieClicked(movie: Movie) {
        _movie.value = movie
    }
}