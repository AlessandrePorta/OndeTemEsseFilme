package com.example.ondetemessefilme.ui.home

import androidx.lifecycle.*
import com.example.ondetemessefilme.data.network.Repository
import kotlinx.coroutines.flow.collect

class HomeViewModel (private val repository: Repository) : ViewModel() {

    private val _homeMovies = MutableLiveData<Unit>()

    val homeMovies = _homeMovies.switchMap {
        liveData {
            repository.getMovies().collect {
                emit(it)
            }
        }
    }

    fun fetchMovies(){
        _homeMovies.postValue(Unit)
    }
}
