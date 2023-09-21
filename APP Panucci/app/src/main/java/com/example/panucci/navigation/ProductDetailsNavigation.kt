package com.example.panucci.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.screens.ProductDetailsScreen

fun NavGraphBuilder.productDetailsScreen(navController: NavHostController) {
	composable(AppDestination.ProductDetails.route) {
		ProductDetailsScreen(
			product = sampleProducts.random(),
		) {
			navController.navigate(AppDestination.Checkout.route)
		}
	}
}