# BlueZone: Augason Skate Analysis

**Course:** Saint Leo University – COM-437 Mobile Application Development  
**Developer:** Noah Augason  
**App Name:** BlueZone (BZ)  
**Platform:** Android (Kotlin, Jetpack Compose, API 30+)

---

## What this app does
BlueZone helps skaters and families quickly compare Bay Area skateparks. I focused on the things I actually check before loading the car with my two daughters: terrain, size, features, cleanliness, safety notes, photo links, review links, and a map link. Each park also shows a simple **family-friendly score** (0–100) so parents can scan fast.

**Core flow**
- **Launch → “Enter” → Skateparks list → Tap a card → Park detail → Back to list**

**No network required.** All park data is bundled locally in the app.

---

## Screens
- **Launch:** BZ logo with an Enter button.
- **List:** Scrollable card list with name, city, and terrain.
- **Detail:** Full profile—features, cleanliness notes, safety notes, photos, reviews, Google Maps link, and a family-friendly progress bar.

---

## Tech & Structure
- **Kotlin + Jetpack Compose (Material 3)**
- **Navigation:** `NavHost` (Launch → List → Detail)
- **Data model:** `Skatepark` (name, city, address, terrain, sizeSqFt, features, cleanlinessNotes, safety, photos, mapsUrl, reviewLinks, familyScore)
- **Local dataset:** `SkateparkData` (curated entries for each park)
- **Files**
  - `MainActivity.kt` – App theme + navigation graph
  - `ParkListScreen.kt` – List UI (cards)
  - `ParkDetailScreen.kt` – Detail UI + Back button + external links
  - `skatepark.kt` – Data class
  - `SkateparkData.kt` – All park entries

---

## Dataset (included parks)

### Brentwood, CA — **Brentwood Skate Park**
- **Address:** 195 Griffith Ln, Brentwood, CA 94513  
- **Terrain:** Mixed (street + transition) — **Size:** ~18,000 sq ft  
- **Features:** concrete plaza; quarters/banks; rails; ledges  
- **Cleanliness:** City facility; generally well used; sunrise–sunset  
- **Safety:** Helmets/knee/elbow pads required; video surveillance  
- **Photos:** WestCoastSkateparks gallery  
- **Maps:** https://maps.google.com/?q=195+Griffith+Ln,+Brentwood,+CA+94513  
- **References:** Brentwood city page; WestCoastSkateparks; GOSKATE; MapQuest

### Livermore, CA — **Sunken Gardens Skate Park**
- **Address:** 3800 Pacific Ave, Livermore, CA 94550  
- **Terrain:** Mixed (flow/bowls + street) — **Size:** ~11,000 sq ft  
- **Features:** flow bowl; street area; adjacent walking/bike paths  
- **Cleanliness:** Positive community feedback; shade in areas  
- **Safety:** LARPD park; dawn–dusk typical  
- **Photos:** LARPD page; WestCoastSkateparks gallery  
- **Maps:** https://maps.google.com/?q=3800+Pacific+Ave,+Livermore,+CA+94550  
- **References:** LARPD; GOSKATE; MapQuest

### Pleasanton, CA — **Val Vista Inline Skate Park & Hockey Rink**
- **Address:** 7350 Johnson Dr, Pleasanton, CA 94588  
- **Terrain:** Inline/roller rink used by skaters; **not** a dedicated bowl park  
- **Features:** full-size inline rink; boards/goals; adjacent park amenities  
- **Cleanliness:** Generally positive park reviews  
- **Safety:** City park; follow posted signage/hours  
- **Photos:** Yelp page  
- **Maps:** https://maps.google.com/?q=7350+Johnson+Dr,+Pleasanton,+CA+94588  
- **References:** City facility info; GOSKATE; Yelp

### Fremont, CA — **Central Park Skatepark (Fremont Skate Park)**
- **Address:** 40000–40500 Paseo Padre Pkwy, Fremont, CA 94538  
- **Terrain:** Mixed (multiple bowls + street plazas + snake run) — **Size:** ~25,000–30,000+ sq ft  
- **Features:** kidney/combi bowls; street plaza; snake run; flow sections  
- **Cleanliness:** Active community spot; lots of recent photos  
- **Safety:** City rules; dawn–dusk / posted hours  
- **Photos:** StrayRocket; community galleries  
- **Maps:** https://maps.google.com/?q=Central+Park+Skatepark,+Fremont,+CA+94538  
- **References:** City pages; StrayRocket; Yelp

### Scotts Valley, CA — **Tim Brauch Memorial Skatepark (Skypark)**
- **Address:** 361 Kings Village Rd, Scotts Valley, CA 95066  
- **Terrain:** Mixed (deep bowls + flow/snake + street) — **Size:** ~20,000–22,000 sq ft  
- **Features:** clover/deep bowls; flow lines; street features  
- **Cleanliness:** Well-regarded; steady use; many current photos  
- **Safety:** City park; follow posted hours  
- **Photos:** Yelp; WestCoastSkateparks  
- **Maps:** https://maps.google.com/?q=361+Kings+Village+Rd,+Scotts+Valley,+CA+95066  
- **References:** WestCoastSkateparks; Yelp; GOSKATE; MapQuest

### Santa Cruz, CA — **Ken Wormhoudt Skate Park (Mike Fox Park)**
- **Address:** 225 San Lorenzo Blvd, Santa Cruz, CA 95060  
- **Terrain:** Mixed (pool bowls + full pipe + street) — **Size:** ~15,000 sq ft  
- **Features:** two bowls w/ pool coping; full pipe; street area  
- **Cleanliness:** Popular coastal park; steady 4★ sentiment  
- **Safety:** Typical city supervision/hours; respect signage  
- **Photos:** Yelp photos  
- **Maps:** https://maps.google.com/?q=225+San+Lorenzo+Blvd,+Santa+Cruz,+CA+95060  
- **References:** City of Santa Cruz; Yelp; MapQuest

### Oakland, CA — **Town Park Skateboarding (DeFremery Park)**
- **Address:** 1651 Adeline St (park); 1269–18th St skate area, Oakland, CA 94607  
- **Terrain:** Mixed (DIY + plaza/ramps; community/event space)  
- **Features:** ramps; plaza elements; community events  
- **Cleanliness:** Active community venue; lots of recent photos  
- **Safety:** City park hours; urban awareness; go during active times  
- **Photos:** Yelp page  
- **Maps:** https://maps.google.com/?q=1651+Adeline+St,+Oakland,+CA+94607  
- **References:** Oakland city pages; Visit Oakland; WestCoastSkateparks

### Oakland, CA — **Youth UpRising Skate Plaza**
- **Address:** 8711–8751 MacArthur Blvd, Oakland, CA 94605  
- **Terrain:** Street plaza — **Size:** ~19,000 sq ft  
- **Features:** stairs; hubbas; rails; manual pads; banks  
- **Cleanliness:** On Youth UpRising campus; access aligns with campus ops  
- **Safety:** Campus facility; check hours/access details  
- **Photos:** WestCoastSkateparks  
- **Maps:** https://maps.google.com/?q=8711+MacArthur+Blvd,+Oakland,+CA+94605  
- **References:** Youth UpRising; WestCoastSkateparks; GOSKATE

### Oakland, CA — **Rainbow Recreation Center Skate Area**
- **Address:** 5800 International Blvd, Oakland, CA 94621  
- **Terrain:** Community skate spot/plaza at a renovated rec complex  
- **Features:** outdoor rec complex; skate elements vary by renovation  
- **Cleanliness:** Busy center; current photos on Yelp  
- **Safety:** Well-lit complex; standard rec hours; urban awareness  
- **Photos:** Yelp  
- **Maps:** https://maps.google.com/?q=5800+International+Blvd,+Oakland,+CA+94621  
- **References:** Oakland city page; Concrete Disciples; Yelp

### Berkeley, CA — **Berkeley Skate Park (Terrence McCrary Jr. Memorial)**
- **Address:** 711 Harrison St, Berkeley, CA 94710  
- **Terrain:** Mixed (street course + pool-style bowls) — **Size:** ~18,000 sq ft  
- **Features:** large oval/combination bowl; smaller bowl; rails/ledges/banks; beginner areas  
- **Cleanliness:** Well-maintained city facility with programs  
- **Safety:** Open daily; follow onsite rules  
- **Photos:** Yelp; Skatedex  
- **Maps:** https://maps.google.com/?q=711+Harrison+St,+Berkeley,+CA+94710  
- **References:** City of Berkeley; Yelp; community listings

> Note on square footage: Some ranges vary by source (e.g., Fremont is widely cited ~25k–30k+). I used conservative figures and included references.

---

## How to run
1. Open in Android Studio (Giraffe+).  
2. Let Gradle sync.  
3. Select an emulator (API 30+) and **Run**.  
4. Enter → Skateparks → pick a park → Back.

---
