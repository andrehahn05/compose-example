package com.example.appdelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.appdelivery.ui.theme.AppDeliveryTheme
import com.example.appdelivery.ui.theme.Red40

import com.example.appdelivery.ui.theme.Red80
import com.example.appdelivery.ui.theme.Yellow40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDeliveryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductItem()
                }
            }
        }
    }
}



@Composable
fun ProductItem() {

    Column() {
        Box(
            Modifier
                .heightIn(200.dp, 250.dp)
                .background(Brush.linearGradient(listOf(Red80, Red40, Yellow40)))
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .offset(y = 50.dp)
                    .clip(CircleShape)
                    .align(BottomCenter)

            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column() {
            Text(text = LoremIpsum(50).values.first(),maxLines = 2,)
            Text(text = LoremIpsum(50).values.first(),maxLines = 2,)
        }
    }
}

@Preview(name = "ProductItem", showSystemUi = true)
@Composable
fun ProductItemPreview() {
    AppDeliveryTheme {
        ProductItem()
    }
}