
package com.example.appdelivery.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.appdelivery.sampledata.sampleSections
import com.example.appdelivery.ui.components.ProductsSection


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            text, { newValue ->
                text = newValue
            },

            Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 20.dp,
                )
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
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
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
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sampleSections)
}