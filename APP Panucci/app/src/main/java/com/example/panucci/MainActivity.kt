package com.example.panucci

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PointOfSale
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.whenCreated
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.panucci.navigation.AppDestination
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.navigation.bottomAppBarItems
import com.example.panucci.sampledata.sampleProducts
import com.example.panucci.ui.components.BottomAppBarItem
import com.example.panucci.ui.components.PanucciBottomAppBar
import com.example.panucci.ui.screens.CheckoutScreen
import com.example.panucci.ui.screens.DrinksListScreen
import com.example.panucci.ui.screens.HighlightsListScreen
import com.example.panucci.ui.screens.MenuProductScreen
import com.example.panucci.ui.screens.ProductDetailsScreen
import com.example.panucci.ui.theme.PanucciTheme

class MainActivity: ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			val navController = rememberNavController()
			LaunchedEffect(Unit) {
				navController.addOnDestinationChangedListener { _,_,_ ->
					val routes = navController.backQueue.map {
						it.destination.route
					}
					Log.i("MainActivity","onCreate: back stack - $routes")
				}
			}
			val backStackEntryState by navController.currentBackStackEntryAsState()
			val currentDestination = backStackEntryState?.destination
			PanucciTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					val selectedItem by remember(currentDestination) {
						val item = currentDestination?.let { destination ->
							bottomAppBarItems.find {
								it.destination.route == destination.route
							}
						} ?: bottomAppBarItems.first()
						mutableStateOf(item)
					}
					val containsInBottomAppBarItems = currentDestination?.let { destination ->
						bottomAppBarItems.find {
							it.destination.route == destination.route
						}
					} != null
					val isShowFab = when (currentDestination?.route) {
						AppDestination.Menu.route,
						AppDestination.Drinks.route,
						-> true

						else -> false
					}
					PanucciApp(
						bottomAppBarItemSelected = selectedItem,
						onBottomAppBarItemSelectedChange = {
							val route = it.destination.route
							navController.navigate(route) {
								launchSingleTop = true
								popUpTo(route)
							}
						},
						onFabClick = {
							navController.navigate(AppDestination.Checkout.route)
						},
						isShowTopBar = containsInBottomAppBarItems,
						isShowBottomBar = containsInBottomAppBarItems,
						isShowFab = isShowFab
					) {
						NavHost(
							navController = navController,
							startDestination = AppDestination.Highlight.route
						) {
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
							composable(AppDestination.Menu.route) {
								MenuProductScreen(
									products = sampleProducts,
									onNavigateToDetails = {
										navController.navigate(AppDestination.ProductDetails.route)
									},
								)
							}
							composable(AppDestination.Drinks.route) {
								DrinksListScreen(
									products = sampleProducts,
								) {
									navController.navigate(AppDestination.ProductDetails.route)
								}
							}
							composable(AppDestination.ProductDetails.route) {
								ProductDetailsScreen(
									product = sampleProducts.random(),
								) {
									navController.navigate(AppDestination.Checkout.route)
								}
							}
							composable(AppDestination.Checkout.route) {
								CheckoutScreen(products = sampleProducts)
							}
						}
					}
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanucciApp(
	bottomAppBarItemSelected: BottomAppBarItem = bottomAppBarItems.first(),
	onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
	onFabClick: () -> Unit = {},
	isShowTopBar: Boolean = false,
	isShowBottomBar: Boolean = false,
	isShowFab: Boolean = false,
	content: @Composable () -> Unit,
) {
	Scaffold(
		topBar = {
			if (isShowTopBar) {
				CenterAlignedTopAppBar(
					title = {
						Text(text = "Ristorante Panucci")
					},
				)
			}
		},
		bottomBar = {
			if (isShowBottomBar) {
				PanucciBottomAppBar(
					item = bottomAppBarItemSelected,
					items = bottomAppBarItems,
					onItemChange = onBottomAppBarItemSelectedChange,
				)
			}
		},
		floatingActionButton = {
			if (isShowFab) {
				FloatingActionButton(
					onClick = onFabClick
				) {
					Icon(
						Icons.Filled.PointOfSale,
						contentDescription = null
					)
				}
			}
		}
	) {
		Box(
			modifier = Modifier.padding(it)
		) {
			content()
		}
	}
}

@Preview
@Composable
private fun PanucciAppPreview() {
	PanucciTheme {
		Surface {
			PanucciApp {}
		}
	}
}