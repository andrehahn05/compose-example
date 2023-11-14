package com.example.panucci.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.panucci.ui.screens.MenuProductScreen
import com.example.panucci.ui.viewmodels.MenuListViewModel

internal const val menuRoute = "menu"
fun NavGraphBuilder.menuScreen(navController: NavHostController) {
    composable(menuRoute) {
        val viewModel = viewModel<MenuListViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        MenuProductScreen(
            uiState = uiState,
            onNavigateToDetails = { product ->
                navController.navigate(product.id)
            },
        )
    }
}

fun NavController.navigateToMenu(navOptions: NavOptions? = null) {
    navigate(menuRoute, navOptions)
}