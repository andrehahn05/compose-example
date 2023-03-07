package com.example.appdelivery.extensions

import java.math.BigDecimal
import java.text.NumberFormat

fun BigDecimal.toBrazilianCurrency(): String {
    return NumberFormat
        .getCurrencyInstance()
        .format(this)
}