package com.example.appdelivery.ui.screens

import com.example.appdelivery.ui.components.SearchTextField
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appdelivery.model.Product
import com.example.appdelivery.sampledata.sampleProducts
import com.example.appdelivery.sampledata.sampleSections
import com.example.appdelivery.ui.components.CardProductItem
import com.example.appdelivery.ui.components.ProductsSection
import com.example.appdelivery.ui.theme.AppDeliveryTheme


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column {
        var text by remember { mutableStateOf(searchText) }
        SearchTextField(
            searchText = text,
            onSearchChange = {
                text = it
            },
        )

        val searchedProducts = remember(text) {
            if (text.isNotBlank()) {

                sampleProducts.filter { product ->
                    product.name.contains(
                        text,
                        ignoreCase = true,
                    ) || product.description?.contains(
                        text,
                        ignoreCase = true,
                    ) ?: false
                }
            } else emptyList()
        }



        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (text.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title, products = products
                        )
                    }
                }

            } else {

                items(searchedProducts) { products ->
                    CardProductItem(
                        products,
                        Modifier.padding(horizontal = 16.dp),

                        )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sampleSections)
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenWithSearchPreview() {
    AppDeliveryTheme {
        HomeScreen(
            sampleSections,
            searchText = "a",
        )
    }
}