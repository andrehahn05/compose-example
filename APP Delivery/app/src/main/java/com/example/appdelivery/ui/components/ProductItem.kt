package com.example.appdelivery.ui.components



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appdelivery.ui.theme.AppDeliveryTheme
import com.example.appdelivery.ui.theme.Red40
import com.example.appdelivery.ui.theme.Red80
import com.example.appdelivery.ui.theme.Yellow40
import com.example.appdelivery.R


@Composable
fun ProductItem() {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 6.dp,
        modifier = Modifier.padding(8.dp),
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
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
                Image(
                    painter =  painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(100.dp)
                        .offset(y = 50.dp)
                        .clip(CircleShape)
                        .align(BottomCenter)

                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    maxLines = 2,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "R$ 20,25",
                    Modifier.padding(top = 4.dp),
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                )
            }
        }
    }
}

@Preview(name = "ProductItem", showBackground = true)
@Composable
fun ProductItemPreview() {
    AppDeliveryTheme {
        ProductItem()
    }
}