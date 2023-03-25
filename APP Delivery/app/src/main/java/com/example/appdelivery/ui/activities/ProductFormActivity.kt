

package com.example.appdelivery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.appdelivery.ui.theme.AppDeliveryTheme

class ProductFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDeliveryTheme {
                ProductFormScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen() {
    Column {
        Text(text = "Criando o Produto")
        var url by remember {
            mutableStateOf("")
        }
        TextField(value = url, onValueChange = {
            url = it
        })

        var name by remember {
            mutableStateOf("")
        }
        TextField(value = name, onValueChange = {
            name = it
        })

        var price by remember {
            mutableStateOf("")
        }
        TextField(value = price, onValueChange = {
            price = it
        })

        var description by remember {
            mutableStateOf("")
        }
        TextField(value = description, onValueChange = {
            description  = it
        })

    }

}

@Preview(showSystemUi = true)
@Composable
fun ProductFormScreenPreview() {
    AppDeliveryTheme {
        ProductFormScreen()
    }
}
