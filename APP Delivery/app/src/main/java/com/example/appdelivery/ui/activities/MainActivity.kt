package com.example.appdelivery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.appdelivery.dao.ProductDao
import com.example.appdelivery.sampledata.sampleSections
import com.example.appdelivery.ui.screens.HomeScreen
import com.example.appdelivery.ui.states.HomeScreenUiState
import com.example.appdelivery.ui.theme.AppDeliveryTheme
import com.example.appdelivery.ui.viewmodels.HomeScreenViewModel

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
                                this, ProductFormActivity::class.java
                            )
                        )
                    }) {
                        val viewModel by viewModels<HomeScreenViewModel>()
                        HomeScreen(viewModel)
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    AppDeliveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(
                    onClick = onFabClick,
                    containerColor = colorScheme.primaryContainer,
                    contentColor = Color.Black,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                    )
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App {
        HomeScreen(HomeScreenUiState(sections = sampleSections))
    }
}