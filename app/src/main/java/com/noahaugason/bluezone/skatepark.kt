package com.noahaugason.bluezone

// Data class to hold skatepark information
data class Skatepark(
    val name: String,
    val city: String,
    val address: String,
    val terrain: String,
    val sizeSqFt: Int,
    val features: List<String>,
    val cleanlinessNotes: String,
    val safety: List<String>,
    val photos: List<String>,
    val mapsUrl: String,
    val reviewLinks: List<String>
)