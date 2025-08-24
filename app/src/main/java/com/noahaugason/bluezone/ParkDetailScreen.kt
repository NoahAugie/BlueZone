package com.noahaugason.bluezone

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri   // Cleaner KTX way to handle Uri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkDetailScreen(
    park: Skatepark,
    onBackClick: () -> Unit   // Sends the user back to the list
) {
    val context = LocalContext.current

    // Helper so I do not repeat the Intent code for every link
    fun open(link: String) {
        context.startActivity(Intent(Intent.ACTION_VIEW, link.toUri()))
    }

    Scaffold(
        // Centered title looks better because some park names are long
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(park.name) },
                navigationIcon = {
                    // Kept this a plain text button to avoid extra icon dependencies
                    TextButton(onClick = onBackClick) { Text("Back") }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                // Header block with quick park info
                Text(text = park.city, style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(6.dp))

                // Address is tappable so it opens Google Maps
                Text(
                    text = "Address: ${park.address}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.clickable { open(park.mapsUrl) }
                )
                Text(text = "Terrain: ${park.terrain}", style = MaterialTheme.typography.bodyMedium)
                if (park.sizeSqFt > 0) {
                    Text(text = "Size: ${park.sizeSqFt} sq ft", style = MaterialTheme.typography.bodyMedium)
                }

                // Family-friendly score section
                if (park.familyScore in 1..100) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "Family-friendly: ${park.familyScore}%",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold)
                    )
                    // Progress bar makes the percentage feel more visual
                    LinearProgressIndicator(
                        progress = { park.familyScore / 100f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                    )
                }

                // Features section
                Spacer(Modifier.height(8.dp))
                Text("Features", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(4.dp))
                park.features.forEach { feature ->
                    Text("• $feature", style = MaterialTheme.typography.bodySmall)
                }

                // Cleanliness notes
                Spacer(Modifier.height(8.dp))
                Text("Cleanliness", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(4.dp))
                Text(park.cleanlinessNotes, style = MaterialTheme.typography.bodySmall)

                // Safety section
                Spacer(Modifier.height(8.dp))
                Text("Safety", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(4.dp))
                park.safety.forEach { rule ->
                    Text("• $rule", style = MaterialTheme.typography.bodySmall)
                }

                // Photo links (clickable)
                if (park.photos.isNotEmpty()) {
                    Spacer(Modifier.height(8.dp))
                    Text("Photos", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    park.photos.forEach { link ->
                        Text(
                            text = link,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.clickable { open(link) }
                        )
                    }
                }

                // Review links (clickable)
                if (park.reviewLinks.isNotEmpty()) {
                    Spacer(Modifier.height(8.dp))
                    Text("Reviews", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    park.reviewLinks.forEach { link ->
                        Text(
                            text = link,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.clickable { open(link) }
                        )
                    }
                }
            }
        }
    }
}