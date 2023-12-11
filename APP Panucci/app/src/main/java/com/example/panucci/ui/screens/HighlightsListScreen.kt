package com.example.panucci.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.panucci.model.Product
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.components.HighlightProductCard
import com.example.panucci.ui.theme.PanucciTheme
import com.example.panucci.ui.theme.caveatFont
import com.example.panucci.ui.uistate.HighlightsListUiState

@Composable
fun HighlightsListScreen(
    modifier: Modifier = Modifier,
    title: String = "Destaques do dia",
	onOrderClick: () -> Unit = {},
	onProductClick: (Product) -> Unit = {},
    uiState: HighlightsListUiState = HighlightsListUiState()
) {
	val products = uiState.products
	Column(modifier.fillMaxSize()) {
		Surface {
			Text(
				text = title,
				modifier
					.fillMaxWidth()
					.padding(vertical = 8.dp),
				fontFamily = caveatFont,
				fontSize = 32.sp,
				textAlign = TextAlign.Center
			)
		}
		LazyColumn(
			modifier
				.fillMaxSize(),
			contentPadding = PaddingValues(16.dp),
			verticalArrangement = Arrangement.spacedBy(16.dp)
		) {
			items(products) { p ->
				HighlightProductCard(
					product = p,
					modifier
						.semantics {
							contentDescription = "highlight product card item"
						}
						.clickable {
						onProductClick(p)
					},
					onOrderClick = onOrderClick
				)
			}
		}
	}
}


@Preview
@Composable
fun HighlightsListScreenPreview() {
	PanucciTheme {
		Surface {
			HighlightsListScreen(
                title = "Destaques do dia",
                uiState = HighlightsListUiState(
					products = sampleProducts
				)
            )
		}
	}
}