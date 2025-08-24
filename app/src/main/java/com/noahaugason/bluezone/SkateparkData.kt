package com.noahaugason.bluezone

object SkateparkData {
    val parks: List<Skatepark> = listOf(
        Skatepark(
            name = "Brentwood Skate Park",
            city = "Brentwood, CA",
            address = "195 Griffith Ln, Brentwood, CA 94513",
            terrain = "Mixed concrete (street + transition)",
            sizeSqFt = 18000,
            features = listOf("quarters","banks","rails","ledges","plaza"),
            cleanlinessNotes = "Active community spot; recent video review 7/10",
            safety = listOf("Helmets/knee/elbow pads required","Sunrise–sunset","Video surveillance"),
            photos = listOf(
                "https://www.youtube.com/watch?v=TSwdr6h61Hc",
                "https://www.westcoastskateparks.com/skateparks/brentwood-skatepark-brentwood-california"
            ),
            mapsUrl = "https://maps.google.com/?q=195+Griffith+Ln,+Brentwood,+CA+94513",
            reviewLinks = listOf(
                "https://www.brentwoodca.gov/",
                "https://www.westcoastskateparks.com/skateparks/brentwood-skatepark-brentwood-california"
            )
        ),
        Skatepark(
            name = "Sunken Gardens Skate Park (Livermore)",
            city = "Livermore, CA",
            address = "3800 Pacific Ave, Livermore, CA 94550",
            terrain = "Mixed concrete (flow/bowls + street)",
            sizeSqFt = 11000,
            features = listOf("flow/bowls","street elements","adjacent bike course"),
            cleanlinessNotes = "4.5/5 aggregate; smooth transitions & shade",
            safety = listOf("Dawn–dusk typical","Park district facility"),
            photos = listOf(
                "https://www.westcoastskateparks.com/skateparks/sunken-gardens-skatepark-livermore-california",
                "https://www.mapquest.com/us/california/sunken-gardens-skate-park-267696616"
            ),
            mapsUrl = "https://maps.google.com/?q=3800+Pacific+Ave,+Livermore,+CA+94550",
            reviewLinks = listOf(
                "https://www.larpd.org/sunken-gardens-skate-park",
                "https://wanderlog.com/",
                "https://goskate.com/"
            )
        ),
        Skatepark(
            name = "Central Park Skatepark (Fremont)",
            city = "Fremont, CA",
            address = "40000 Paseo Padre Pkwy, Fremont, CA 94538",
            terrain = "Mixed; multiple bowls, street plazas, snake run",
            sizeSqFt = 30000,
            features = listOf("multiple bowls","street plaza","snake run"),
            cleanlinessNotes = "Popular/community-maintained feel; many recent photos",
            safety = listOf("Helmets & protective gear required by city rules"),
            photos = listOf(
                "https://www.strayrocket.com/fremont-skatepark/",
                "https://skatedex.com/central-park-skatepark/"
            ),
            mapsUrl = "https://maps.google.com/?q=Central+Park+Skatepark,+Fremont,+CA+94538",
            reviewLinks = listOf("https://www.goskate.com/","https://www.yelp.com/")
        ),
        Skatepark(
            name = "Berkeley Skate Park",
            city = "Berkeley, CA",
            address = "711 Harrison St, Berkeley, CA 94710",
            terrain = "Street plaza + pool-style bowls",
            sizeSqFt = 0, // unknown size; 0 is fine for now
            features = listOf("street plaza","ledges","rails","bowl zone"),
            cleanlinessNotes = "Well-maintained city facility; used by skate schools",
            safety = listOf("Observe onsite rules at Harrison Field complex"),
            photos = listOf(
                "https://skatedex.com/berkeley-skate-park/",
                "https://www.cityofberkeley.info/SkatePark/"
            ),
            mapsUrl = "https://maps.google.com/?q=711+Harrison+St,+Berkeley,+CA+94710",
            reviewLinks = listOf("https://www.cityofberkeley.info/SkatePark/")
        )
    )
}