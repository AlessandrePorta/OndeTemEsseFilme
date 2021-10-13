package com.example.ondetemessefilme.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.ondetemessefilme.R

class HomeAdapter(
    private val homeMoviesList: List<HomeMovies>,
    private val context : Context
) :
    Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.movies_home_list, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = homeMoviesList[position]
        holder.bind(item)
    }

    override fun getItemCount() = homeMoviesList.size
}