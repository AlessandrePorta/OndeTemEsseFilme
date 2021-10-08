package com.example.ondetemessefilme.utils

import android.util.Patterns

fun String.validateEmail(email: CharSequence?): Boolean {
    return email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun String.validatePassword(password: CharSequence?): Boolean{
    return password != null && password.contains(uppercase()) && password.contains(lowercase())
}

fun String.validateName(name: CharSequence?): Boolean{
    return name != null && name.isEmpty() && name.isBlank()
}