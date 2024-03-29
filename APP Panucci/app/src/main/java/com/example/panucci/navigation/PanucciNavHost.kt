package com.example.panucci.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

internal const val  uri = "example://panucci.com"
@Composable
fun PanucciNavHost(navController: NavHostController) {
	NavHost(
		navController = navController,
		startDestination = homeGraphRoute
	) {
		homeGraph(
			onNavigateToCheckout = {
				navController.navigateToCheckout()
			},
			onNavigateToProductDetails = { product ->
				navController.navigateToProductDetails(product.id)
			},
		)
		productDetailsScreen(
			onNavigateToCheckout = {
				navController.navigateToCheckout()
			},
			onPopBackStack = {
				navController.navigateUp()
			},
		)
		checkoutScreen(
			onPopBackStack = {
				navController.currentBackStackEntry
					?.savedStateHandle
					?.set("order_done", "✅ Pedido realizado com sucesso")
				navController.navigateUp()
			},
		)
	}

}

