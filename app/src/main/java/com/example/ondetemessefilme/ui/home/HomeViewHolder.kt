package com.example.ondetemessefilme.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movies_home_list.view.*

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val title = itemView.movie_title
    val voteAverage = itemView.movie_vote_average
    val movieImg = itemView.movie_img

    fun bind(homeMovies: HomeMovies){
        title.text = homeMovies.title
        voteAverage.text = homeMovies.vote_average.toString()
        Glide.with(itemView.context)
            .load("https://image.tmdb.org/t/p/original" + homeMovies.poster_path)
            .into(movieImg)
    }
}
