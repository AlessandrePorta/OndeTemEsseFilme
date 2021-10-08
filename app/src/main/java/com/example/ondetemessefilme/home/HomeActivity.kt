package com.example.ondetemessefilme.home

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ondetemessefilme.R

class HomeActivity : AppCompatActivity(){

    private val homeViewModel = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
    }

    fun movieClickSucces() {

    }

}