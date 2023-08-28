package com.example.panucci.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.panucci.R
import com.example.panucci.model.Product
import com.example.panucci.sampledata.sampleProductWithImage
import com.example.panucci.sampledata.sampleProductWithoutImage
import com.example.panucci.ui.theme.PanucciTheme

@Composable
fun MenuProductCard(
	product: Product,
	modifier: Modifier = Modifier,
) {
	Card(
		modifier
			.fillMaxWidth()
			.height(80.dp)
	) {
		Row{
			Column(
				modifier
					.padding(16.dp)
					.weight(3f)

			) {
				Text(
					text = product.name,
					maxLines = 1,
					overflow = TextOverflow.Ellipsis,
					fontSize = 16.sp,
					fontWeight = FontWeight(500)
				)
				Spacer(modifier.height(4.dp))
				Text(
					text = product.price.toPlainString(),
					Modifier.fillMaxWidth(),
					maxLines = 1,
					overflow = TextOverflow.Ellipsis,
					fontWeight = FontWeight(400)
				)
			}

			product.image?.let { image ->
				AsyncImage(
					model = image,
					contentDescription = null,
					modifier
						.width(80.dp)
						.fillMaxHeight(),
					placeholder = painterResource(id = R.drawable.placeholder),
					contentScale = ContentScale.Crop

				)

			}
		}
	}
}

@Preview
@Composable
fun MenuProductCardPreview() {
	PanucciTheme {
		MenuProductCard(
			product = sampleProductWithoutImage
		)
	}
}

@Preview
@Composable
fun MenuProductCardWithImagePreview() {
	PanucciTheme {
		MenuProductCard(
			product = sampleProductWithImage
		)
	}
}