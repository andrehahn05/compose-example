package com.example.panucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.screens.MenuProductScreen

private const val menuRoute = "menu"
fun NavGraphBuilder.menuScreen(navController: NavHostController) {
	composable(menuRoute) {
		MenuProductScreen(
			products = sampleProducts,
			onNavigateToDetails = {
				navController.navigate(AppDestination.ProductDetails.route)
			},
		)
	}
}

fun NavController.navigateToMenu() {
	navigate(menuRoute)
}