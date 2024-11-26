package com.example.watchlist.ui


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class Movie(val id: Int, val label: String, initialChecked: Boolean = false){
    var checked by mutableStateOf(initialChecked)
}
