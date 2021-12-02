package com.example.ondetemessefilme.utils

fun String.validateEmail(): Boolean {
    return !this.isEmpty() && !this.isBlank() && this.contains("@") && this.contains(".")
}

fun String.validatePassword(): Boolean{
    return !this.isBlank() && !this.isEmpty() && this.length >= 8
}

fun String.validateName(): Boolean{
    return !this.isEmpty() && !this.isBlank()
}