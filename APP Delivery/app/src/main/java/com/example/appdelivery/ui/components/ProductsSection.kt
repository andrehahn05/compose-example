package com.example.appdelivery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appdelivery.ui.theme.AppDeliveryTheme

@Composable
fun ProductsSection() {
    Column() {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
        )
        Row(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            Arrangement.spacedBy(16.dp)) {
            Spacer(Modifier)
            for (i in 1..4) {
                ProductItem()
            }
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true, widthDp = 600)
@Composable
fun ProductsSectionPreviw() {
    AppDeliveryTheme {
        ProductsSection()
    }
}