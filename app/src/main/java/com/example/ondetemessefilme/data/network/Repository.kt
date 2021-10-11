package com.example.ondetemessefilme.data.network

import kotlinx.coroutines.flow.flow

class Repository(private val endpoint: Endpoint) {

    fun getMovies() = flow { emit(endpoint.getHomeMovies()) }

}