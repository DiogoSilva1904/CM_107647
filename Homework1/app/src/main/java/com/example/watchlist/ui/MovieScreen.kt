package com.example.watchlist.ui
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MovieScreen(modifier: Modifier = Modifier, movieViewModel: MovieViewModel = viewModel()){
    var newMovieLabel by remember { mutableStateOf("") }

    Column(modifier = modifier){
        TextField(
            value = newMovieLabel,
            onValueChange = { newMovieLabel = it },
            label = { Text("Label") },
            maxLines = 2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Button(
            onClick = {
                if (newMovieLabel.isNotEmpty()) {
                    movieViewModel.addMovie(newMovieLabel)
                    newMovieLabel = "" // Reset input after adding
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Movie")
        }
        MovieList(
            list = movieViewModel.tasks,
            onCheckedTask = { task, checked ->
                movieViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                movieViewModel.remove(task)
            }
        )
    }
}

