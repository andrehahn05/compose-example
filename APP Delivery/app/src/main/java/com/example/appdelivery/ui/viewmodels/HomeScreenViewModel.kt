package com.example.appdelivery.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdelivery.dao.ProductDao
import com.example.appdelivery.model.Product
import com.example.appdelivery.sampledata.sampleCandies
import com.example.appdelivery.sampledata.sampleDrinks
import com.example.appdelivery.sampledata.sampleProducts
import com.example.appdelivery.ui.states.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDao()

    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()
    init {
        _uiState.update { currentState ->
            currentState.copy(
                onSearchChange = {
                    _uiState.value = _uiState.value.copy(
                        searchText = it,
                        searchedProducts = searchedProducts(it)
                    )
                }
            )
        }

        viewModelScope.launch {
            dao.products().collect { products ->
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Salgados" to sampleProducts,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks,
                        "Novo Produto" to products,
                    ),
                    searchedProducts = searchedProducts(_uiState.value.searchText)
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