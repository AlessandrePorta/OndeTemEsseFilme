package com.example.ondetemessefilme.data.network

import PageInfo
import retrofit2.http.GET

interface Endpoint {

    @GET("discover/movie?api_key=7f354262f4121e2f7f35dd3a8c07cb2e")
    suspend fun getHomeMovies() : PageInfo

}