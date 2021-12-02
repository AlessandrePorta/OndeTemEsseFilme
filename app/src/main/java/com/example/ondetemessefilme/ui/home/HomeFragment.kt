package com.example.ondetemessefilme.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ondetemessefilme.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : AppCompatActivity() {

    private lateinit var homeAdapter: HomeAdapter
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        init()
    }

    private fun init() {
        homeViewModel.homeMovies.observe(this) { setupMoviesList(it) }
        homeViewModel.homeMovies.observe(this) { searchMovies() }
        homeViewModel.fetchMovies()

    }

    private fun setupMoviesList(movieResponse: HomePageInfo) {
        val recyclerView = findViewById<RecyclerView>(R.id.movies_home_list)
        recyclerView.adapter = HomeAdapter(movieResponse.results, this)

        initAdapter(movieResponse.results)
    }

    private fun initAdapter(response: MutableList<HomeMovies>) {
        val rv_list = findViewById<RecyclerView>(R.id.movies_home_list)

        homeAdapter = HomeAdapter(
            response,
            this
        )

        rv_list.adapter = homeAdapter
    }

    private fun searchMovies() {
        val rl_search = findViewById<EditText>(R.id.et_search)
        val rv_list = findViewById<RecyclerView>(R.id.movies_home_list)

        rl_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var listaAux = homeAdapter.homeMoviesList.filter {
                    it.title.lowercase().contains(s.toString().lowercase())
                }
                rv_list.adapter = HomeAdapter(listaAux.toMutableList(), this@HomeFragment)
                rv_list.adapter?.notifyDataSetChanged()
            }
        })
    }

}