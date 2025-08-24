package com.noahaugason.bluezone

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.noahaugason.bluezone.ui.theme.BlueZoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // I wrap the whole app in my theme so the styling is consistent
            BlueZoneTheme {
                AppNavigation()
            }
        }
    }
}

/**
 * I keep my navigation graph in one place.
 * Start at the launch screen, then go to the list, then into a detail page per park.
 */
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "launch" // I want the app to open on the logo screen
    ) {
        // Logo + Enter button
        composable("launch") {
            LaunchScreen(
                onEnterClick = { navController.navigate("parkList") }
            )
        }

        // Scrollable list of parks
        composable("parkList") {
            // NOTE: in the next step I’ll update ParkListScreen to accept onParkClick(name)
            // and navigate to detail. I’m wiring the route here so it’s ready.
            ParkListScreen(
                onParkClick = { parkName ->
                    // Park names have spaces, so I encode them before putting in the route
                    navController.navigate("detail/${Uri.encode(parkName)}")
                }
            )
        }

        // Detail page for a single park
        composable(
            route = "detail/{parkName}",
            arguments = listOf(navArgument("parkName") { type = NavType.StringType })
        ) { backStackEntry ->
            val encoded = backStackEntry.arguments?.getString("parkName")
            val parkName = encoded?.let { Uri.decode(it) }
            val park = SkateparkData.parks.find { it.name == parkName }

            if (park != null) {
                ParkDetailScreen(
                    park = park,
                    onBackClick = { navController.popBackStack() } // back arrow takes me to the list
                )
            } else {
                // Simple fallback in case the name didn't match for some reason
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text("Park not found")
                    }
                }
            }
        }
    }
}

// I keep LaunchScreen here so it’s easy to tweak the intro without hunting for files
@Composable
fun LaunchScreen(onEnterClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo front and center
        Image(
            painter = painterResource(id = R.drawable.bz_logo),
            contentDescription = "BlueZone Logo",
            modifier = Modifier
                .size(500.dp)
                .offset(x = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Title + Enter button
        Column(
            modifier = Modifier.offset(y = (-220).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "BlueZone", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onEnterClick) {
                Text("Enter")
            }
        }
    }
}