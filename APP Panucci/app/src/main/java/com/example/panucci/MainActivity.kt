package com.example.panucci

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.panucci.ui.theme.PanucciTheme

class MainActivity: ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PanucciTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					PanucciApp("Panucci")
				}
			}
		}
	}
}

@Composable
fun PanucciApp(name: String,modifier: Modifier = Modifier) {
	Text(
		text = "App $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun PanucciAppPreview() {
	PanucciTheme {
		PanucciApp("App Panucci")
	}
}