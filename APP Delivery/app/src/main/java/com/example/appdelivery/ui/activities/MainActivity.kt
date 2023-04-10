package com.example.appdelivery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appdelivery.sampledata.sampleSections
import com.example.appdelivery.ui.screens.HomeScreen
import com.example.appdelivery.ui.theme.AppDeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDeliveryTheme {
                Surface(
                    color = colorScheme.background,

                    ) {
                    App(onFabClick = {
                        startActivity(
                            Intent(
                                this,
                                ProductFormActivity::class.java
                            )
                        )
                    })
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(onFabClick: () -> Unit) {
    AppDeliveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick,
                    containerColor = colorScheme.surfaceColorAtElevation(4.dp),
                    contentColor = colorScheme.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                    )
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {

                    HomeScreen(sampleSections)

                }
            }
        }
    }
}