package com.noahaugason.bluezone

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkListScreen(onParkClick: (Skatepark) -> Unit) {
    // I use a Scaffold so I can keep a top bar and the list separated
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Skateparks") }) }
    ) { padding ->
        // LazyColumn lets me scroll through all the parks without writing a ton of boilerplate
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // I loop through all the parks and make a card for each one
            items(SkateparkData.parks) { park ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onParkClick(park) }, // tap sends me to the detail screen
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    shape = MaterialTheme.shapes.large
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            // Name is bold/larger so it stands out
                            Text(
                                text = park.name,
                                style = MaterialTheme.typography.titleLarge,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            // I also show the city and terrain type since those are quick filters in real life
                            Text(text = park.city, style = MaterialTheme.typography.bodyMedium)
                            Text(text = park.terrain, style = MaterialTheme.typography.bodySmall)
                        }
                        // I added a simple chevron so the user understands they can actually tap it
                        Text("›", style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
    }
}