package com.example.appdelivery.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appdelivery.R
import com.example.appdelivery.extensions.toBrazilianCurrency
import com.example.appdelivery.model.Product
import com.example.appdelivery.sampledata.sampleProducts
import com.example.appdelivery.ui.theme.AppDeliveryTheme

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 6.dp
) {
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        )
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(colorScheme.onPrimary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    color = colorScheme.secondary
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    color = colorScheme.tertiary
                )
            }

        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AppDeliveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
            )
        }
    }
}

