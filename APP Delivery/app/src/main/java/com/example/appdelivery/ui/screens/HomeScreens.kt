package com.example.appdelivery.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = "",
) {
    Column {
        var text by remember { mutableStateOf(searchText) }

        OutlinedTextField(
            text, { newValue ->
                text = newValue
            },

            Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(colorScheme.background),
            shape = RoundedCornerShape(50.dp),

            leadingIcon = {
                Modifier
                Icon(Icons.Default.Search, contentDescription = "ícone de pesquisa")
            },
            label = {
                Text(text = "Produto")
            },
            placeholder = {
                Text(text = "O que você procura?")
            }
        )
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (text.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }

            } else {

                items(sampleProducts) { products ->
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