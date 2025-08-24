package com.noahaugason.bluezone

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ParkListScreen() {
    // I used a Scaffold so I can easily add a top app bar to this screen
    Scaffold(
        topBar = {
            // This is the bar that shows at the very top with the title
            CenterAlignedTopAppBar(
                title = { Text("Skateparks") }
            )
        }
    ) { padding ->
        // I went with LazyColumn so the list scrolls if I add a lot of parks
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                // I apply the padding that Scaffold gives me so the list doesn't overlap the app bar
                .padding(padding)
                .padding(16.dp)
        ) {
            // Here I loop through all the parks I set up in my SkateparkData file
            items(SkateparkData.parks) { park ->
                // Each park is shown inside a card so it looks clean and separated
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    // Inside the card, I stack the park details vertically
                    Column(modifier = Modifier.padding(16.dp)) {
                        // I start with the park name in large text
                        Text(text = park.name, style = MaterialTheme.typography.titleLarge)
                        // Then I show the city
                        Text(text = park.city, style = MaterialTheme.typography.bodyMedium)
                        // And finally the type of terrain
                        Text(text = park.terrain, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}