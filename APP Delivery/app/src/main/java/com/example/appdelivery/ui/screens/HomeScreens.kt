package com.example.appdelivery.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appdelivery.model.Product
import com.example.appdelivery.sampledata.sampleCandies
import com.example.appdelivery.sampledata.sampleDrinks
import com.example.appdelivery.sampledata.sampleProducts
import com.example.appdelivery.sampledata.sampleSections
import com.example.appdelivery.ui.components.CardProductItem
import com.example.appdelivery.ui.components.ProductsSection
import com.example.appdelivery.ui.components.SearchTextField
import com.example.appdelivery.ui.theme.AppDeliveryTheme

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {
    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }
}

@Composable
fun HomeScreen(products: List<Product>) {
    val sections = mapOf(
        "Promoções" to sampleDrinks + sampleCandies,
        "Salgados" to sampleProducts,
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks,
        "Novo Produto" to products,
    )
    var text by remember {
        mutableStateOf("")
    }

    fun containsInName() = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        )
    }

    val searchedProducts = remember(text, products) {
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInName()) +
                    products.filter(containsInName())
        } else emptyList()
    }

    val state = remember(products, text) {
        HomeScreenUiState(
            sections = sections,
            searchedProducts = searchedProducts,
            searchText = text,
            onSearchChange = {
                text = it
            }
        )
    }
    HomeScreen(state = state)
}
@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val sections = state.sections
        val text = state.searchText
        val searchedProducts = state.searchedProducts
        SearchTextField(
            searchText = text,
            onSearchChange = state.onSearchChange,
            Modifier.fillMaxWidth(),
        )

        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (state.isShowSections()) {
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
    AppDeliveryTheme {
        HomeScreen(HomeScreenUiState(sections = sampleSections))
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenWithSearchPreview() {
    AppDeliveryTheme {
        HomeScreen(
            state = HomeScreenUiState(
                searchText = "a",
                sections = sampleSections,
            ),
        )
    }
}