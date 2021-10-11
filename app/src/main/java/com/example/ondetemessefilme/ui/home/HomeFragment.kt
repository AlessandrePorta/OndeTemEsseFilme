package com.example.ondetemessefilme.ui.home

import PageInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ondetemessefilme.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : AppCompatActivity(){

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        init()
    }

    private fun init(){
        homeViewModel.homeMovies.observe(this){ setupMoviesList(it) }
        homeViewModel.fetchMovies()
    }

    private fun setupMoviesList(movieResponse : PageInfo){
        val recyclerView = findViewById<RecyclerView>(R.id.movies_home_list)
        recyclerView.adapter = HomeAdapter(movieResponse.results, this)
    }

}