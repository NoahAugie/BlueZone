package com.noahaugason.bluezone

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkListScreen(
    onParkClick: (String) -> Unit  // I pass the park name up so navigation can handle it
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Skateparks") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            items(SkateparkData.parks) { park ->
                Card(
                    onClick = { onParkClick(park.name) }, // tap goes to the detail screen
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = park.name, style = MaterialTheme.typography.titleLarge)
                        Text(text = park.city, style = MaterialTheme.typography.bodyMedium)
                        Text(text = park.terrain, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}