@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.appdelivery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appdelivery.ui.theme.AppDeliveryTheme


@Composable
fun SearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = { newValue ->
            onSearchChange(newValue)
        },
        modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        shape = RoundedCornerShape(50.dp),
        maxLines = 1,

        leadingIcon = {
            Modifier
            Icon(Icons.Default.Search, contentDescription = "ícone de pesquisa")
        },
        label = {
            Text(text = "Produto")
        },
        placeholder = {
            Text(text = "O que você procura?")
        })
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldWithSearchPreview() {
    AppDeliveryTheme{
        SearchTextField(
            searchText = "a",
            onSearchChange = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchTextFieldPreview() {
    AppDeliveryTheme{
        SearchTextField(
            "",
            onSearchChange = {},
        )
    }
}


