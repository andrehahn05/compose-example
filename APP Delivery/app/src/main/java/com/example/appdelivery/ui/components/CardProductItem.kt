package com.example.appdelivery.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    isExpanded: Boolean = false
) {
    var expanded by rememberSaveable {
        mutableStateOf(isExpanded)
    }
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable {
                expanded = !expanded
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        ),

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
                modifier = Modifier
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
            if (expanded) {
                product.description?.let {
                    Text(
                        text = product.description,
                        Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun CardProductItemPreview() {
    AppDeliveryTheme {
        CardProductItem(
            product = Product(
                name = "teste",
                price = BigDecimal("9.99")
            ),
        )
    }
}

@Preview
@Composable
fun CardProductItemWithDescriptionPreview() {
    AppDeliveryTheme {
        CardProductItem(
            product = sampleProducts.random(),
        )
    }
}