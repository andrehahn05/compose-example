package com.example.panucci.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.screens.CheckoutScreen

fun NavGraphBuilder.checkoutScreen() {
	composable(AppDestination.Checkout.route) {
		CheckoutScreen(products = sampleProducts)
	}
}