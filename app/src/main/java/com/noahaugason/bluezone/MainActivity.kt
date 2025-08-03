package com.noahaugason.bluezone

import android.os.Bundle
import android.util.Log
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
import com.noahaugason.bluezone.ui.theme.BlueZoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlueZoneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    LaunchScreen {
                        Log.d("BlueZone", "Enter button clicked")
                    }
                }
            }
        }
    }
}

@Composable
fun LaunchScreen(onEnterClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.bz_logo),
            contentDescription = "BlueZone Logo",
            modifier = Modifier
                .size(500.dp)
                .offset(x = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

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
            Button(onClick = onEnterClick) {
                Text(text = "Enter")
            }
        }
    }
}