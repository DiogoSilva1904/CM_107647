package com.example.watchlist.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel(){
    val _tasks = mutableStateListOf<Movie>().apply{addAll(init_movies())}

    val tasks: List<Movie>
        get() = _tasks


    fun remove(item: Movie) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: Movie, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

    fun addMovie(label: String) {
        val newMovie = Movie(id = tasks.size + 1, label = label)
        _tasks.add(newMovie)
    }
}

fun init_movies(): List<Movie> {
    return listOf(
        Movie(id = 1, label = "Breaking Bad", initialChecked = false),
        Movie(id = 2, label = "Ozark", initialChecked = false),
        Movie(id = 3, label = "Better Call Saul", initialChecked = false)
    )
}