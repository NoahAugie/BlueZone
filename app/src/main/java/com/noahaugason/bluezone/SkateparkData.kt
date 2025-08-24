package com.noahaugason.bluezone

// I put all my researched skatepark data into this object so I can use it in the app
object SkateparkData {
    // I wanted an easy way to grab all the parks as one list, so I just store them here
    val parks: List<Skatepark> = listOf(
        Skatepark(
            name = "Brentwood Skate Park",
            city = "Brentwood, CA",
            address = "195 Griffith Ln, Brentwood, CA 94513",
            terrain = "mixed (street + transition)",
            sizeSqFt = 18000,
            features = listOf("concrete plaza", "quarters/banks", "rails", "ledges"),
            cleanlinessNotes = "City facility; generally well used; open sunrise–sunset.",
            safety = listOf("Helmets and pads required per posted rules", "Open sunrise–sunset"),
            photos = listOf("https://www.westcoastskateparks.com/skateparks/brentwood-skatepark-brentwood-california"),
            mapsUrl = "https://maps.google.com/?q=195+Griffith+Ln,+Brentwood,+CA+94513",
            reviewLinks = listOf("https://goskate.com/sp/listing/brentwood-ca-skatepark/")
        ),
        // I really like that this one has a mix of flow and street
        Skatepark(
            name = "Sunken Gardens Skate Park",
            city = "Livermore, CA",
            address = "3800 Pacific Ave, Livermore, CA 94550",
            terrain = "mixed (bowls/flow + street)",
            sizeSqFt = 11000,
            features = listOf("flow bowl", "street area", "adjacent walking/bike paths"),
            cleanlinessNotes = "LARPD notes park opened 2001; community reviews typically positive.",
            safety = listOf("Public park; dawn–dusk typical for the area"),
            photos = listOf("https://www.larpd.org/sunken-gardens-skate-park"),
            mapsUrl = "https://maps.google.com/?q=3800+Pacific+Ave,+Livermore,+CA+94550",
            reviewLinks = listOf(
                "https://goskate.com/sp/listing/livermore-skatepark/",
                "https://www.mapquest.com/us/california/sunken-gardens-skate-park-267696616"
            )
        ),
        // Pleasanton’s is more of a hockey/inline setup, so I noted size as 0 since it’s not a true skatepark
        Skatepark(
            name = "Val Vista Inline Skate Park & Hockey Rink",
            city = "Pleasanton, CA",
            address = "7350 Johnson Dr, Pleasanton, CA 94588",
            terrain = "inline/roller rink; skaters use the paved area (not a dedicated bowl park)",
            sizeSqFt = 0,
            features = listOf("full-size inline rink", "boards/goals", "adjacent multi-use park amenities"),
            cleanlinessNotes = "General park reviews positive; facility primarily designed for inline/hockey.",
            safety = listOf("City park facility; observe posted signage and hours"),
            photos = listOf("https://www.yelp.com/biz/val-vista-community-park-pleasanton"),
            mapsUrl = "https://maps.google.com/?q=7350+Johnson+Dr,+Pleasanton,+CA+94588",
            reviewLinks = listOf(
                "https://goskate.com/sp/listing/pleasanton-skatepark/",
                "https://www.yelp.com/biz/val-vista-community-park-pleasanton"
            )
        ),
        // Fremont is huge, definitely one of the biggest in the Bay
        Skatepark(
            name = "Central Park Skatepark (Fremont Skate Park)",
            city = "Fremont, CA",
            address = "40000–40500 Paseo Padre Pkwy, Fremont, CA 94538",
            terrain = "mixed (multiple bowls + street plazas + snake run)",
            sizeSqFt = 25000,
            features = listOf("kidney/combi bowls", "street plaza", "snake run", "flow sections"),
            cleanlinessNotes = "Widely cited as one of the largest/most complete parks in the Bay Area; active community and photos.",
            safety = listOf("City rules; Dawn–Dusk or until 8:00 p.m. (per city page)"),
            photos = listOf(
                "https://www.strayrocket.com/fremont-skatepark/",
                "https://www.yelp.com/biz/fremont-skate-park-fremont"
            ),
            mapsUrl = "https://maps.google.com/?q=Central+Park+Skatepark,+Fremont,+CA+94538",
            reviewLinks = listOf("https://www.yelp.com/biz/fremont-skate-park-fremont")
        ),
        Skatepark(
            name = "Tim Brauch Memorial Skatepark (Scotts Valley Skypark)",
            city = "Scotts Valley, CA",
            address = "361 Kings Village Rd, Scotts Valley, CA 95066",
            terrain = "mixed (deep bowls + flow/snake + street)",
            sizeSqFt = 20000,
            features = listOf("clover/deep bowls", "flow lines", "street features"),
            cleanlinessNotes = "Well-regarded; consistent usage; numerous current photos from visitors.",
            safety = listOf("City park setting; observe posted hours"),
            photos = listOf(
                "https://www.yelp.com/biz/scotts-valley-tim-brauch-memorial-skate-park-scotts-valley",
                "https://www.westcoastskateparks.com/skateparks/tim-brauch-memorial-skatepark-scotts-valley-california"
            ),
            mapsUrl = "https://maps.google.com/?q=361+Kings+Village+Rd,+Scotts+Valley,+CA+95066",
            reviewLinks = listOf(
                "https://goskate.com/sp/listing/tim-brauch-memorial-skatepark-scotts-valley-skate-park/",
                "https://www.mapquest.com/us/california/scotts-valley-tim-brauch-memorial-skate-park-372205204"
            )
        ),
        // Santa Cruz has that full pipe, which is pretty unique compared to most parks
        Skatepark(
            name = "Ken Wormhoudt Skate Park (Mike Fox Park)",
            city = "Santa Cruz, CA",
            address = "225 San Lorenzo Blvd, Santa Cruz, CA 95060",
            terrain = "mixed (pool bowls + full pipe + street)",
            sizeSqFt = 15000,
            features = listOf("two bowls with pool coping", "full pipe", "street area"),
            cleanlinessNotes = "Popular coastal park; steady 4★ sentiment on reviews; city facility.",
            safety = listOf("Typical city hours around 9 a.m. to sunset (per listings)", "Observe posted rules"),
            photos = listOf("https://www.yelp.com/biz/ken-wormhoudt-skate-park-santa-cruz"),
            mapsUrl = "https://maps.google.com/?q=225+San+Lorenzo+Blvd,+Santa+Cruz,+CA+95060",
            reviewLinks = listOf("https://www.mapquest.com/us/california/ken-wormhoudt-skate-park-345986985")
        ),
        Skatepark(
            name = "Town Park Skateboarding (DeFremery Park)",
            city = "Oakland, CA",
            address = "1651 Adeline St (park address), 1269–18th St skate area, Oakland, CA 94607",
            terrain = "mixed (DIY + concrete plaza/ramps; event space)",
            sizeSqFt = 0,
            features = listOf("ramps", "plaza elements", "community event space"),
            cleanlinessNotes = "Active community venue with regular events; numerous recent photos.",
            safety = listOf("City park hours; urban setting—use standard awareness and go during active hours/events for visibility"),
            photos = listOf("https://www.yelp.com/biz/defremery-park-oakland"),
            mapsUrl = "https://maps.google.com/?q=1651+Adeline+St,+Oakland,+CA+94607",
            reviewLinks = listOf("https://www.visitoakland.com/listing/defremery-park/8342/")
        ),
        Skatepark(
            name = "Youth UpRising Skate Plaza",
            city = "Oakland, CA",
            address = "8711–8751 MacArthur Blvd, Oakland, CA 94605",
            terrain = "street plaza",
            sizeSqFt = 19000,
            features = listOf("stairs", "hubbas", "rails", "manual pads", "banks"),
            cleanlinessNotes = "On Youth UpRising campus; access aligned with campus operations.",
            safety = listOf("Campus facility; check hours and access; family/youth services setting"),
            photos = listOf("https://www.westcoastskateparks.com/skateparks/youth-uprising-skate-plaza-oakland-california"),
            mapsUrl = "https://maps.google.com/?q=8711+MacArthur+Blvd,+Oakland,+CA+94605",
            reviewLinks = listOf("https://goskate.com/sp/listing/youth-uprising-skate-plaza/")
        ),
        // I set size to 0 here because it’s not consistent across listings and more of a rec center spot
        Skatepark(
            name = "Rainbow Recreation Center Skate Area",
            city = "Oakland, CA",
            address = "5800 International Blvd, Oakland, CA 94621",
            terrain = "community skate spot/plaza at recreation complex",
            sizeSqFt = 0,
            features = listOf("outdoor rec complex with skate elements (varies by renovation)"),
            cleanlinessNotes = "Busy rec center; current photos and activity on Yelp.",
            safety = listOf("Well-lit complex; standard rec center hours; urban location awareness recommended"),
            photos = listOf("https://www.yelp.com/biz/rainbow-recreation-center-oakland"),
            mapsUrl = "https://maps.google.com/?q=5800+International+Blvd,+Oakland,+CA+94621",
            reviewLinks = listOf("https://www.yelp.com/biz/rainbow-recreation-center-oakland-2")
        ),
        Skatepark(
            name = "Berkeley Skate Park (Terrence McCrary Jr. Memorial Skatepark)",
            city = "Berkeley, CA",
            address = "711 Harrison St, Berkeley, CA 94710",
            terrain = "mixed (street course + pool-style bowls)",
            sizeSqFt = 18000,
            features = listOf("large oval/combination bowl", "smaller bowl", "street with rails/ledges/banks", "beginner areas"),
            cleanlinessNotes = "City facility at Harrison Park; frequent programs and steady usage; reviews mention safety and bowl focus.",
            safety = listOf("Open daily; observe onsite rules and posted hours"),
            photos = listOf(
                "https://www.yelp.com/biz/berkeley-skatepark-berkeley",
                "https://skatedex.com/berkeley-skate-park/"
            ),
            mapsUrl = "https://maps.google.com/?q=711+Harrison+St,+Berkeley,+CA+94710",
            reviewLinks = listOf(
                "https://www.yelp.com/biz/berkeley-skatepark-berkeley",
                "https://www.berkeleyparentsnetwork.org/recommend/org/berkeley-skate-park"
            )
        )
    )
}