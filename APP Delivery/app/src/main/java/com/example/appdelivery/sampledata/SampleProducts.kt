package com.example.appdelivery.sampledata

import com.example.appdelivery.R
import com.example.appdelivery.model.Product
import java.math.BigDecimal
val sampleCandies = listOf(
    Product(
        name = "Chocolate",
        price = BigDecimal("10.95"),
        image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
    ),
    Product(
        name = "Sorvete",
        price = BigDecimal("10.99"),
        image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
    ),
    Product(
        name = "Bolo",
        price = BigDecimal("15.99"),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
    )
)

val sampleDrinks = listOf(
    Product(
        name = "Cerveja",
        price = BigDecimal("6.99"),
        image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
    ),
    Product(
        name = "Refrigerante",
        price = BigDecimal("8.99"),
        image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"
    ),
    Product(
        name = "Suco",
        price = BigDecimal("8.95"),
        image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"
    ),
    Product(
        name = "Água",
        price = BigDecimal("4.50"),
        image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
    )
)

val sampleProducts: List<Product> = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("25.50"),
        image ="https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"

    ),
    Product(
        name = "Pizza",
        price = BigDecimal("45.99"),
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("12.99"),
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"

    ), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)

val sampleSections = mapOf(
    "Promoções" to sampleProducts,
    "Doces" to sampleCandies,
    "Bebidas" to sampleDrinks
)
