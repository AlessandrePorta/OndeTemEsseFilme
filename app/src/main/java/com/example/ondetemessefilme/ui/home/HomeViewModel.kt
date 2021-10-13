package com.example.ondetemessefilme.ui.home

import androidx.lifecycle.*
import com.example.ondetemessefilme.utils.toLiveData

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _homeMovies = MutableLiveData<Unit>()

    val homeMovies = _homeMovies.switchMap {
        homeRepository.getMovies().toLiveData()
    }

    fun fetchMovies() {
        _homeMovies.postValue(Unit)
    }
}
