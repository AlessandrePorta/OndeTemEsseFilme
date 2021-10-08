package com.example.ondetemessefilme.login.anonimous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ondetemessefilme.R
import com.example.ondetemessefilme.home.HomeActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class AnonimousActivity : AppCompatActivity() {

    private val loginAnonimousViewModel by lazy{ ViewModelProvider(this)[LoginAnonimousViewModel::class.java]}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anonimous_activity)

        val name = findViewById<TextInputEditText>(R.id.anonimous_name)
        val anonimousButton = findViewById<Button>(R.id.anonimous_button_login)

        loginAnonimousViewModel.anonimousLogin.observe(this, Observer {
            when{
                it.isSuccess -> anonimousLoginSucces()
                else -> validationLoginFeedback(it.errorMessage)
            }
        })

        anonimousButton.setOnClickListener{loginAnonimousViewModel.doAnonimousLogin(AnonimousVO(name.text.toString()))}
    }


    fun validationLoginFeedback(message: String?) {
        message?.let {
            Snackbar.make(findViewById(R.id.anonimous_root), message, Snackbar.LENGTH_SHORT).show()
        }
    }

    fun anonimousLoginSucces(){
        startActivity(Intent(this, HomeActivity::class.java))
    }
}