package com.example.panucci.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun PanucciNavHost(navController: NavHostController) {

	NavHost(
		navController = navController,
		startDestination = highlightsListRoute
	) {
		highlightsListScreen(navController)
		menuScreen(navController)
		drinksScreen(navController)
		productDetailsScreen(navController)
		checkoutScreen(navController)

	}
}