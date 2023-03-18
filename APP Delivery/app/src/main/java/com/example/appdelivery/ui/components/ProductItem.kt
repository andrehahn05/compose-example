package com.example.appdelivery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.appdelivery.R
import com.example.appdelivery.extensions.toBrazilianCurrency
import com.example.appdelivery.model.Product
import com.example.appdelivery.ui.theme.*
import java.math.BigDecimal


@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp,
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
               .background(white40)
        ) {
            Box(
                Modifier
                    .height(100.dp)
                    .background(
                        Brush.linearGradient(
                            listOf(
                                Red80,
                                Red40,
                                Yellow40
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    Modifier
                        .size(100.dp)
                        .offset(y = 50.dp)
                        .clip(CircleShape)
                        .align(BottomCenter),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }


            Spacer(modifier = Modifier.height(50.dp))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    maxLines = 2,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,

                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    Modifier.padding(top = 4.dp),
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Preview(name = "ProductItem", showBackground = true,)
@Composable
fun ProductItemPreview() {
    AppDeliveryTheme {
        ProductItem(
            Product(
                name = LoremIpsum(50).values.first(),
                price = BigDecimal("14.99"),

            )
        )
    }
}