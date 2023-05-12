package com.example.appdelivery.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdelivery.dao.ProductDao
import com.example.appdelivery.model.Product
import com.example.appdelivery.sampledata.sampleCandies
import com.example.appdelivery.sampledata.sampleDrinks
import com.example.appdelivery.sampledata.sampleProducts
import com.example.appdelivery.ui.states.HomeScreenUiState
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDao()

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            onSearchChange = {
                uiState = uiState.copy(
                    searchText = it,
                    searchedProducts = searchedProducts(it)
                )
            }
        ))
        private set


    init {
        viewModelScope.launch {
            dao.products().collect { products ->
                uiState = uiState.copy(
                    sections = mapOf(
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Salgados" to sampleProducts,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks,
                        "Novo Produto" to products,
                    )
                )
            }
        }
    }


    private fun containsInName(text: String) = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        )
    }

    private fun searchedProducts(text: String): List<Product> =
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInName(text)) +
                    dao.products().value.filter(containsInName(text))
        } else emptyList()
}