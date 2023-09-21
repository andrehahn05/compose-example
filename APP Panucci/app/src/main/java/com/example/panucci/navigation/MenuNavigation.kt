package com.example.panucci.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.screens.MenuProductScreen

fun NavGraphBuilder.menuScreen(navController: NavHostController) {
	composable(AppDestination.Menu.route) {
		MenuProductScreen(
			products = sampleProducts,
			onNavigateToDetails = {
				navController.navigate(AppDestination.ProductDetails.route)
			},
		)
	}
}