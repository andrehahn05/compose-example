package com.example.appdelivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.appdelivery.sampledata.sampleSections
import com.example.appdelivery.ui.screens.HomeScreen
import com.example.appdelivery.ui.theme.AppDeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDeliveryTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,

                    ) {
                    App()
                }
            }
        }
    }
}
@Composable
fun App() {
    AppDeliveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}