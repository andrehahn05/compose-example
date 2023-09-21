package com.example.panucci.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.screens.HighlightsListScreen

fun NavGraphBuilder.highlightsListScreen(navController: NavHostController) {
	composable(AppDestination.Highlight.route) {
		HighlightsListScreen(
			products = sampleProducts,
			onNavigateToDetails = {
				navController.navigate(AppDestination.ProductDetails.route)
			},
			onNavigateToCheckout = {
				navController.navigate(AppDestination.Checkout.route)
			},
		)
	}
}