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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.panucci.model.Product
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.components.MenuProductCard
import com.example.panucci.ui.theme.PanucciTheme
import com.example.panucci.ui.theme.caveatFont

@Composable
fun MenuListScreen(
	modifier: Modifier = Modifier,
	products: List<Product> = emptyList(),
	title: String = "Menu",
	onNavigateToDetails: (Product) -> Unit = {},
) {
	Column(modifier.fillMaxWidth()) {
		Surface {
			Text(
				text = title,
				modifier
					.fillMaxWidth()
					.padding(horizontal = 8.dp),
				fontSize = 32.sp,
				fontFamily = caveatFont,
				textAlign = TextAlign.Center
			)
		}
		LazyColumn(
			modifier.fillMaxSize(),
			contentPadding = PaddingValues(16.dp),
			verticalArrangement = Arrangement.spacedBy(8.dp)

		) {
			items(products) { p ->
				MenuProductCard(
					product = p,
					modifier = Modifier
						.clickable {
							onNavigateToDetails(p)
						}
				)
			}
		}
	}
}

@Preview
@Composable
fun MenuProductScreenPreview() {
	PanucciTheme {
		Surface {
			MenuListScreen(
				products = sampleProducts,
			)
		}
	}
}