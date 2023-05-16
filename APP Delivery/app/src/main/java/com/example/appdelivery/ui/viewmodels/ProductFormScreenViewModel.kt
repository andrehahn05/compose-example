package com.example.appdelivery.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.appdelivery.dao.ProductDao
import com.example.appdelivery.ui.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductFormScreenViewModel: ViewModel() {
    private val dao = ProductDao()

    private val _uiState: MutableStateFlow<ProductFormUiState> = MutableStateFlow(
        ProductFormUiState()
    )
    val uiState get() = _uiState.asStateFlow()
}