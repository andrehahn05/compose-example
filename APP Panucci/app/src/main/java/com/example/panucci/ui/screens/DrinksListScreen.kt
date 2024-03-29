package com.example.panucci.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import com.example.panucci.ui.components.DrinkProductCard
import com.example.panucci.ui.theme.PanucciTheme
import com.example.panucci.ui.theme.caveatFont
import com.example.panucci.ui.uistate.DrinksListUiState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DrinksListScreen(
    modifier: Modifier = Modifier,
    title: String = "Bebidas",
    columns: Int = 2,
	onProductClick: (Product) -> Unit = {},
    uiState: DrinksListUiState = DrinksListUiState()
) {
	val products = uiState.products
	Column(
		modifier
			.fillMaxSize()
	) {
		Surface {
			Text(
				text = title,
				Modifier
					.fillMaxWidth()
					.padding(vertical = 8.dp),
				fontFamily = caveatFont,
				fontSize = 32.sp,
				textAlign = TextAlign.Center
			)
		}
		LazyVerticalStaggeredGrid(
			columns = StaggeredGridCells.Fixed(columns),
			Modifier.fillMaxSize(),
			contentPadding = PaddingValues(16.dp),
			horizontalArrangement = Arrangement.spacedBy(16.dp)
		) {
			
			items(products) { p ->
				DrinkProductCard(
					product = p,
					Modifier
						.semantics { contentDescription = "drink product card item" }
						.clickable {
						onProductClick(p)
					}.padding(bottom = 16.dp)
				)
			}
		}
	}
}

@Preview
@Composable
fun DrinksListScreenPreview() {
	PanucciTheme {
		Surface {
			DrinksListScreen(
                title = "Bebidas",
                uiState = DrinksListUiState(
					products = sampleProducts
				)
            )
		}
	}
}