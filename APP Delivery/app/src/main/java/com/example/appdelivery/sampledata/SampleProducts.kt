package com.example.appdelivery.sampledata

import com.example.appdelivery.R
import com.example.appdelivery.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("25.50"),
        image = R.drawable.hamburguer,

    ),
    Product(
        name = "Pizza",
        price = BigDecimal("45.99"),
        image = R.drawable.pizza
    ),
    Product(
        name = "Lasanha",
        price = BigDecimal("48.90"),
        image = R.drawable.lasanha

    ),
    Product(
        name = "Sushi",
        price = BigDecimal("95.00"),
        image = R.drawable.sushi

    ),
)
