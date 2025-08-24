package com.noahaugason.bluezone

import android.content.Intent
import androidx.core.net.toUri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkDetailScreen(
    park: Skatepark,
    onBackClick: () -> Unit // this just takes me back to the list
) {
    val context = LocalContext.current

    // I use this helper so I don’t repeat the intent code for links
    fun open(link: String) {
        val intent = Intent(Intent.ACTION_VIEW, link.toUri()) // KTX toUri() version
        context.startActivity(intent)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(park.name) },
                navigationIcon = {
                    // kept this as text so I don’t need extra icon dependencies
                    TextButton(onClick = onBackClick) { Text("Back") }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                // basic identity
                Text(text = park.city, style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(8.dp))

                // address opens Maps when tapped
                Text(
                    text = "Address: ${park.address}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.clickable { open(park.mapsUrl) }
                )
                Spacer(Modifier.height(8.dp))

                Text(text = "Terrain: ${park.terrain}", style = MaterialTheme.typography.bodyMedium)
                if (park.sizeSqFt > 0) {
                    Text(
                        text = "Size: ${park.sizeSqFt} sq ft",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(Modifier.height(12.dp))

                // family score — this is the quick read for parents
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Family-friendly: ${park.familyScore}%",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                // New API requires a lambda for progress
                LinearProgressIndicator(
                    progress = { park.familyScore / 100f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                Spacer(Modifier.height(12.dp))

                // features
                Text("Features", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(4.dp))
                park.features.forEach { feature ->
                    Text("• $feature", style = MaterialTheme.typography.bodySmall)
                }
                Spacer(Modifier.height(12.dp))

                // cleanliness
                Text("Cleanliness", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(4.dp))
                Text(park.cleanlinessNotes, style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(12.dp))

                // safety
                Text("Safety", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(4.dp))
                park.safety.forEach { s ->
                    Text("• $s", style = MaterialTheme.typography.bodySmall)
                }
                Spacer(Modifier.height(12.dp))

                // photos
                if (park.photos.isNotEmpty()) {
                    Text("Photos", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    park.photos.forEach { link ->
                        Text(
                            text = link,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.clickable { open(link) }
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                }

                // reviews
                if (park.reviewLinks.isNotEmpty()) {
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