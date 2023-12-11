package com.example.panucci.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.example.panucci.ui.screens.ProductDetailsScreen
import com.example.panucci.ui.viewmodels.ProductDetailsViewModel

internal const val productDetailsRoute = "productDetails"
internal const val productIdArgument = "productId"
internal const val promoCodeArgument = "promoCode"
fun NavGraphBuilder.productDetailsScreen(
    onNavigateToCheckout: () -> Unit,
    onPopBackStack: () -> Unit
) {
    composable(
        "$productDetailsRoute/{$productIdArgument}",
        deepLinks = listOf(
            navDeepLink {
                uriPattern =
                    "$uri/$productDetailsRoute/{$productIdArgument}?$promoCodeArgument={$promoCodeArgument}"
            },
        ),
    ) { backStackEntry ->
        backStackEntry.arguments?.getString(productIdArgument)?.let { id ->
            val viewModel = viewModel<ProductDetailsViewModel>(
                factory = ProductDetailsViewModel.Factory
            )
            val uiState by viewModel.uiState.collectAsState()

            ProductDetailsScreen(
                uiState = uiState,
                onOrderClick = onNavigateToCheckout,
                onTryFindProductAgainClick = {
                    viewModel.findProductById(id)
                },
                onBackStack = onPopBackStack
            )
        } ?: LaunchedEffect(Unit) {
            onPopBackStack()
        }
    }
}


fun NavController.navigateToProductDetails(id: String) {
    navigate("$productDetailsRoute/$id")
}