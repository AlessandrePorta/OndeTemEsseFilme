package com.example.ondetemessefilme.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ondetemessefilme.R
import com.example.ondetemessefilme.ui.home.HomeFragment
import com.example.ondetemessefilme.ui.anonimous.AnonimousFragment
import com.google.android.material.snackbar.Snackbar

class LoginFragment : AppCompatActivity() {

    private val loginViewModel by lazy{ViewModelProvider(this)[LoginViewModel::class.java]}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val email = findViewById<EditText>(R.id.email_login)
        val password = findViewById<EditText>(R.id.senha_login)
        val loginButton = findViewById<Button>(R.id.login_button)
        val anonimousButton = findViewById<Button>(R.id.anonimous_view_button)

        loginViewModel.login.observe(this, Observer {
            when {
                it.isSuccess -> loginSuccess()
                else ->
                    validationLoginFeedback(it.errorMessage)
            }
        })

        loginButton.setOnClickListener { loginViewModel.doLogin(LoginVO(email.text.toString(), password.text.toString())) }
        anonimousButton.setOnClickListener{ startActivity(Intent(this, AnonimousFragment::class.java)) }
    }

    fun validationLoginFeedback(message: String?) {
        message?.let {
            Snackbar.make(findViewById(R.id.login_root), message, Snackbar.LENGTH_SHORT).show()
        }
    }

    fun loginSuccess() {
        startActivity(Intent(this, HomeFragment::class.java))
    }
}