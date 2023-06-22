package com.example.panucci.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.panucci.R
import com.example.panucci.model.Product
import com.example.panucci.sampledata.sampleProductWithoutImage
import com.example.panucci.ui.theme.PanucciTheme

@Composable
fun HighlightProductCard(
	product: Product,
	modifier: Modifier = Modifier,
	onOrderClick: () -> Unit = {}
) {
	Card(
		modifier
			.clip(RoundedCornerShape(12.dp))
			.fillMaxWidth()
	) {
		Column(modifier.fillMaxWidth()) {
			product.image?.let { image ->
				AsyncImage(
					image,
					contentDescription = null,
					modifier
						.fillMaxWidth()
						.height(116.dp),
					placeholder = painterResource(id = R.drawable.placeholder),
					contentScale = ContentScale.Crop,
				)
			}
			Column(
				modifier.padding(
					horizontal = 16.dp,
					vertical = 8.dp
				)
			) {
				Text(text = product.name)
				Text(text = product.price.toString())
				Spacer(modifier.height(16.dp))

				Text(
					text = product.description,
					maxLines = 5,
					overflow = TextOverflow.Ellipsis,
				)
				Spacer(modifier.height(18.dp))
			}
			Button(
				modifier = Modifier
					.padding(
						start = 16.dp,
						end = 16.dp,
						bottom = 24.dp
					)
					.clickable {
						onOrderClick()
					}
					.align(Alignment.End),
				onClick = {
					onOrderClick()
				}
			) {
				Text(
					text = "Pedir",
				)
			}
		}
	}
}

@Preview
@Composable
private fun HighlightProductPreview() {
	PanucciTheme {
		HighlightProductCard(
			product = sampleProductWithoutImage
		)
	}
}