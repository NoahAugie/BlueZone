package com.noahaugason.bluezone

// I made this data class so I can keep all the skatepark info organized in one place
data class Skatepark(
    val name: String,            // I use this for the park's actual name
    val city: String,            // I track the city so I can filter or group later
    val address: String,         // Full address so I can tie it to maps
    val terrain: String,         // Quick note on whether it’s street, bowls, or mixed
    val sizeSqFt: Int,           // Approx size in square feet when I could find it
    val features: List<String>,  // I list main features since that’s what skaters look for
    val cleanlinessNotes: String, // I added this so I could include how well kept the park is
    val safety: List<String>,    // Any safety rules or reminders I found
    val photos: List<String>,    // Links to photos so people can preview the park
    val mapsUrl: String,         // Google Maps link for directions
    val reviewLinks: List<String>, // Extra review links I wanted to save
    val familyScore: Int = 0     // I added this so I can show how family-friendly the park is (0–100)
)