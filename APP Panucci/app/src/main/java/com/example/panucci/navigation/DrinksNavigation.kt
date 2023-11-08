package com.example.panucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.screens.DrinksListScreen

internal const val drinksRoute = "drinks"
fun NavGraphBuilder.drinksScreen(navController: NavHostController) {
	composable(drinksRoute) {
		DrinksListScreen(
			products = sampleProducts,
			onNavigateToDetails = { product ->
				navController.navigateToProductDetails(product.id)
			},
		)
	}
}

fun NavController.navigateToDrinks() {
	navigate(drinksRoute)
}