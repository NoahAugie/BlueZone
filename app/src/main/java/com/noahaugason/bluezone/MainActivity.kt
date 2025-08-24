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
            // I wrap the whole app in my theme so the styling stays consistent
            BlueZoneTheme {
                AppNavigation()
            }
        }
    }
}

/**
 * My navigation graph: launch -> list -> detail.
 * I encode park names in the route so spaces don’t break anything.
 */
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "launch"
    ) {
        // Logo + Enter
        composable("launch") {
            LaunchScreen(
                onEnterClick = { navController.navigate("parkList") }
            )
        }

        // Scrollable list of parks
        composable("parkList") {
            ParkListScreen(
                onParkClick = { park ->
                    navController.navigate("detail/${Uri.encode(park.name)}")
                }
            )
        }

        // Detail screen for a single park (found by name)
        composable(
            route = "detail/{parkName}",
            arguments = listOf(navArgument("parkName") { type = NavType.StringType })
        ) { backStackEntry ->
            val encoded = backStackEntry.arguments?.getString("parkName")
            val parkName = encoded?.let(Uri::decode)
            val park = SkateparkData.parks.find { it.name == parkName }

            if (park != null) {
                ParkDetailScreen(
                    park = park,
                    onBackClick = { navController.popBackStack() } // Back returns to the list
                )
            } else {
                // Lightweight fallback if a name can’t be matched
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Park not found")
                }
            }
        }
    }
}

// I keep this here so I can tweak the intro quickly
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

        // Title + Enter
        Column(
            modifier = Modifier.offset(y = (-220).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "BlueZone", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onEnterClick) { Text("Enter") }
        }
    }
}