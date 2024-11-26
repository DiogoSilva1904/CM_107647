import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.watchlist.ui.MovieItem
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp


@Composable
fun StatelessTextAdder(items: List<String>, onAddItem: (String) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = "",
            onValueChange = { onAddItem(it) }, // Update the text state
            label = { Text("Enter text") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Button(onClick = { onAddItem("") }, Modifier.padding(top = 8.dp)) {
            Text("Add Item")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display the list of added items
        items.forEach { item ->
            Text(item, modifier = Modifier.padding(vertical = 4.dp))
        }
    }
}

@Composable
fun StatefulTextAdder(modifier: Modifier = Modifier) {
    var currentText by rememberSaveable { mutableStateOf("") }
    var items by rememberSaveable { mutableStateOf(listOf<String>()) }

    // Add the current text to the list and clear it for next input
    val onAddItem: (String) -> Unit = { text ->
        if (text.isNotEmpty()) {
            items = items + text
            currentText = ""
        }
    }

    StatelessTextAdder(items, onAddItem, modifier)
}