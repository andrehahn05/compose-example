package com.example.appdelivery.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appdelivery.sampledata.sampleSections
import com.example.appdelivery.ui.components.CardProductItem
import com.example.appdelivery.ui.components.ProductsSection
import com.example.appdelivery.ui.components.SearchTextField
import com.example.appdelivery.ui.states.HomeScreenUiState
import com.example.appdelivery.ui.theme.AppDeliveryTheme
import com.example.appdelivery.ui.viewmodels.HomeScreenViewModel



@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val state by viewModel.uiState.collectAsState()
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