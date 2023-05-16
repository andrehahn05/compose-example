package com.example.appdelivery.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.appdelivery.dao.ProductDao
import com.example.appdelivery.model.Product
import com.example.appdelivery.ui.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.math.RoundingMode

class ProductFormScreenViewModel: ViewModel() {
    private val dao = ProductDao()

    private val _uiState: MutableStateFlow<ProductFormUiState> = MutableStateFlow(
        ProductFormUiState()
    )
    val uiState get() = _uiState.asStateFlow()

    private val pattern = Regex("^\\d{1,3}(\\.\\d+)?$")

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onUrlChange = {
                    _uiState.value = _uiState.value.copy(
                        url = it
                    )
                },
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                },
                onPriceChange = ::handlePriceChange,

                onDescriptionChange = {
                    _uiState.value = _uiState.value.copy(
                        description = it
                    )
                }
            )
        }
    }

    private fun handlePriceChange(priceInput: String) {
        try {
            if (priceInput.matches(pattern) || priceInput.isEmpty()) {
                val decimalInput = priceInput.toBigDecimal()
                val formattedPrice = decimalInput.setScale(2, RoundingMode.FLOOR).toString()
                updateUiState { it.copy(price = formattedPrice) }
            }
        } catch (e: IllegalArgumentException) {
            if (priceInput.isBlank()) {
                updateUiState { it.copy(price = priceInput) }
            }
        }
    }

    private fun updateUiState(updateFunction: (ProductFormUiState) -> ProductFormUiState) {
        _uiState.value = updateFunction(_uiState.value)
    }

    fun save() {
        _uiState.value.run {
            val convertedPrice = try {
                BigDecimal(price)
            } catch (e: NumberFormatException) {
                BigDecimal.ZERO
            }
            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = description
            )
            dao.save(product)
        }
    }
}