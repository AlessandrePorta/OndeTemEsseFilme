package com.example.ondetemessefilme.utils

import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun <T> Flow<T>.toLiveData() = liveData { this@toLiveData.collect { emit(it) } }
