package com.example.panucci.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import com.example.panucci.ui.components.DrinkProductCard
import com.example.panucci.ui.theme.PanucciTheme
import com.example.panucci.ui.theme.caveatFont

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DrinksListScreen(
	modifier: Modifier = Modifier,
	title: String = "Bebidas",
	products: List<Product> = emptyList(),
	col: Int = 2,
) {
	Column(modifier.fillMaxWidth()) {
		  Surface {
			    Text(
				    text = title,
				    modifier
					    .fillMaxWidth()
					    .padding(8.dp),
				    fontFamily = caveatFont,
				    fontSize = 32.sp,
				    textAlign = TextAlign.Center
			    )
		  }
		LazyVerticalStaggeredGrid(
			StaggeredGridCells.Fixed(col),contentPadding = PaddingValues(16.dp),
			verticalItemSpacing = Arrangement.spacedBy(16.dp),
			horizontalArrangement = Arrangement.spacedBy(16.dp),
		){
		   items(products) { p ->
			   DrinkProductCard(
				   product = p
			   )
		   }
		}
	}
}

@OptIn(ExperimentalFoundationApi::class)
fun LazyVerticalStaggeredGrid(
	columns: StaggeredGridCells.Fixed,
	contentPadding: PaddingValues,
	verticalItemSpacing: Arrangement.HorizontalOrVertical,
	horizontalArrangement: Arrangement.HorizontalOrVertical,
	content: LazyStaggeredGridScope.() -> Unit
) {}

@Preview
@Composable
fun DrinksListScreenPreview() {
	PanucciTheme {
		Surface {
			DrinksListScreen(
				products = sampleProducts,
				title = "Bebidas"
			)
		}
	}
}