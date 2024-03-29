package com.example.panucci

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.panucci.navigation.checkoutRoute
import com.example.panucci.navigation.drinksRoute
import com.example.panucci.navigation.highlightsListRoute
import com.example.panucci.navigation.menuRoute
import com.example.panucci.navigation.productDetailsRoute
import com.example.panucci.navigation.productIdArgument
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            PanucciApp(navController = navController)
        }
    }

    @Test
    fun appNavHost_verifyStartDestination() {
        composeTestRule.onRoot().printToLog("panucci app")
        composeTestRule
            .onNodeWithText("Destaques do dia")
            .assertIsDisplayed()
    }

    @Test
    fun appNavHost_verifyIfMenuScreenIsDisplayed() {
        composeTestRule.onRoot().printToLog("panucci app")
        composeTestRule.onNodeWithText("Menu")
            .performClick()

        composeTestRule.onAllNodesWithText("Menu")
            .assertCountEquals(2)

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, menuRoute)
    }

    @Test
    fun appNavHost_verifyIfDrinksScreenIsDisplayed() {
        composeTestRule.onRoot().printToLog("panucci app")
        composeTestRule.onNodeWithText("Bebidas")
            .performClick()

        composeTestRule.onAllNodesWithText("Bebidas")
            .assertCountEquals(2)

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, drinksRoute)
    }
    @Test
    fun appNavHost_verifyIfHighlightsScreenIsDisplayed() {
        composeTestRule.onRoot().printToLog("panucci app")
        composeTestRule.onNodeWithText("Destaques")
            .performClick()

        composeTestRule
            .onNodeWithText("Destaques do dia")
            .assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, highlightsListRoute)
    }
    @Test
    fun appNavHost_verifyIfProductDetailsScreenIsDisplayedFromHighlightsListScreen() {
        composeTestRule.onRoot().printToLog("panucci app")
        composeTestRule
            .onAllNodesWithContentDescription("highlight product card item")
            .onFirst()
            .performClick()

        composeTestRule.waitUntil(3000) {
            composeTestRule.onAllNodesWithText("Falha ao buscar o produto")
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText("Falha ao buscar o produto")
            .assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, "$productDetailsRoute/{$productIdArgument}")
    }
    @Test
    fun appNavHost_verifyIfProductDetailsScreenIsDisplayedFromMenuScreen() {
        composeTestRule.onRoot().printToLog("panucci app")
        composeTestRule.onNodeWithText("Menu")
            .performClick()

        composeTestRule
            .onAllNodesWithContentDescription("menu product card item")
            .onFirst()
            .performClick()

        composeTestRule.waitUntil(3000) {
            composeTestRule.onAllNodesWithContentDescription("product details content")
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule
            .onNodeWithContentDescription("product details content")
            .assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, "$productDetailsRoute/{$productIdArgument}")
    }
    @Test
    fun appNavHost_verifyIfProductDetailsScreenIsDisplayedFromDrinksScreen() {
        composeTestRule.onRoot().printToLog("panucci app")
        composeTestRule.onNodeWithText("Bebidas")
            .performClick()

        composeTestRule
            .onAllNodesWithContentDescription("drink product card item")
            .onFirst()
            .performClick()

        composeTestRule.waitUntil(3000) {
            composeTestRule.onAllNodesWithContentDescription("product details content")
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule
            .onNodeWithContentDescription("product details content")
            .assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, "$productDetailsRoute/{$productIdArgument}")

    }
    @Test
    fun appNavHost_VerifyIfCheckoutScreenIsDisplayedFromHighlightsListScreen(){
        composeTestRule.onRoot().printToLog("panucci app")

        composeTestRule.onAllNodesWithText("Pedir")
            .onFirst()
            .performClick()

        composeTestRule.onNodeWithText("Pedido")
            .assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, checkoutRoute)
    }
    @Test
    fun appNavHost_VerifyIfCheckoutScreenIsDisplayedFromMenuScreen(){
        composeTestRule.onRoot().printToLog("panucci app")

        composeTestRule.onNodeWithText("Menu")
            .performClick()

        composeTestRule.onNodeWithContentDescription("Floating Action Button for order")
            .performClick()

        composeTestRule.onNodeWithText("Pedido")
            .assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, checkoutRoute)
    }
    @Test
    fun appNavHost_VerifyIfCheckoutScreenIsDisplayedFromDrinksScreen(){
        composeTestRule.onRoot().printToLog("panucci app")

        composeTestRule.onNodeWithText("Bebidas")
            .performClick()

        composeTestRule.onNodeWithContentDescription("Floating Action Button for order")
            .performClick()

        composeTestRule.onNodeWithText("Pedido")
            .assertIsDisplayed()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, checkoutRoute)
    }
}