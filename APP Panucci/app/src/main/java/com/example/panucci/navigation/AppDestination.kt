package com.example.panucci.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.outlined.LocalBar
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomAppBarItem(
    val label: String,
    val icon: ImageVector
) {
    object HighlightsList : BottomAppBarItem(
        label = "Destaques",
        icon = Icons.Filled.AutoAwesome
    )
    object Menu : BottomAppBarItem(
        label = "Menu",
        icon = Icons.Filled.RestaurantMenu
    )
    object Drinks : BottomAppBarItem(
        label = "Bebidas",
        icon = Icons.Outlined.LocalBar
    )
}

val bottomAppBarItems = listOf(
    BottomAppBarItem.HighlightsList,
    BottomAppBarItem.Menu,
    BottomAppBarItem.Drinks
)