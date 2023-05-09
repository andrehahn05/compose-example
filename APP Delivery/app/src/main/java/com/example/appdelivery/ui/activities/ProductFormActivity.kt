package com.example.appdelivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appdelivery.dao.ProductDao
import com.example.appdelivery.ui.screens.ProductFormScreen
import com.example.appdelivery.ui.theme.AppDeliveryTheme


class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDeliveryTheme {
                ProductFormScreen(
                    onSaveClick = { product ->
                        dao.save(product)
                        finish()
                    })
            }
        }
    }
}