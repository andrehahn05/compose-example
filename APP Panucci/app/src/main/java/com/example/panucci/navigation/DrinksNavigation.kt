package com.example.panucci.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.example.panucci.model.Product
import com.example.panucci.ui.screens.DrinksListScreen
import com.example.panucci.ui.viewmodels.DrinksListViewModel

internal const val drinksRoute = "drinks"
fun NavGraphBuilder.drinksScreen(
    onNavigateToProductDetails: (Product) -> Unit
) {
    composable(drinksRoute,
        deepLinks = listOf(navDeepLink { uriPattern = "$uri/$drinksRoute" })
    ) {
        val viewModel = viewModel<DrinksListViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        DrinksListScreen(
            uiState = uiState,
            onProductClick = onNavigateToProductDetails,
        )
    }
}

fun NavController.navigateToDrinks(
    navOptions: NavOptions? = null
) {
    navigate(drinksRoute, navOptions)
}