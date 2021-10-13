package com.example.ondetemessefilme.ui.home

import com.example.ondetemessefilme.data.network.Endpoint
import kotlinx.coroutines.flow.flow

class HomeRepository(private val endpoint: Endpoint) {

    fun getMovies() = flow { emit(endpoint.getHomeMovies()) }

}