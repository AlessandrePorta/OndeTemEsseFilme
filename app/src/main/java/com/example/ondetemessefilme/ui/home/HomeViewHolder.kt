package com.example.ondetemessefilme.ui.home

import Movies
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movies_home_list.view.*

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val title = itemView.movie_vote_average
    val voteAverage = itemView.movie_vote_average
    val movieImg = itemView.movie_img

    fun bind(movies: Movies){
        title.text = movies.title
        voteAverage.text = movies.vote_average.toString()
        Glide.with(itemView.context)
            .load(movies.poster_path)
            .fitCenter()
            .into(movieImg)
    }
}
