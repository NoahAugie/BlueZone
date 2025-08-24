package com.noahaugason.bluezone

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noahaugason.bluezone.ui.theme.BlueZoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // I wrapped everything in my app's theme so the style is consistent
            BlueZoneTheme {
                // I set up a navigation controller to move between screens
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "launch" // I want the app to open on the launch screen
                ) {
                    // This is my first screen with the logo and Enter button
                    composable("launch") {
                        LaunchScreen(
                            onEnterClick = {
                                // When I click the Enter button, I go to the park list screen
                                navController.navigate("parkList")
                            }
                        )
                    }
                    // This shows the skatepark list after hitting Enter
                    composable("parkList") {
                        ParkListScreen()
                    }
                }
            }
        }
    }
}

// I put the LaunchScreen outside of the class so it’s a reusable composable function
@Composable
fun LaunchScreen(onEnterClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // I added my logo here so it’s front and center
        Image(
            painter = painterResource(id = R.drawable.bz_logo),
            contentDescription = "BlueZone Logo",
            modifier = Modifier
                .size(500.dp)
                .offset(x = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // I stacked the text and button under the logo
        Column(
            modifier = Modifier.offset(y = (-220).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "BlueZone",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            // This is the Enter button that takes me to the next screen
            Button(onClick = onEnterClick) {
                Text(text = "Enter")
            }
        }
    }
}