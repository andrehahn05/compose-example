package com.example.appdelivery.dao

import androidx.compose.runtime.mutableStateListOf
import com.example.appdelivery.model.Product
import com.example.appdelivery.sampledata.sampleProducts

class ProductDao {
    companion object {
        private val products = mutableStateListOf<Product>()
    }
    fun products() = products.toList()
    fun save(product: Product) {
        products.add(product)
    }
}