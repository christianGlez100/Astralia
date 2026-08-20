package com.sesi.astralia.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import astralia.shared.generated.resources.Res
import astralia.shared.generated.resources.ic_stars
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun DiscoverNavigationItem(
    modifier: Modifier = Modifier,
    icon: DrawableResource = Res.drawable.ic_stars,
    text: String = "Discover"
) {
    val goldColor = Color(0xFFE8C24A)
    Column(
        modifier = modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Top Sparkles
        Box(modifier = Modifier.size(24.dp)) {
            Image(painter = painterResource(resource = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp))
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = text,
            style = LocalTextStyle.current.copy(
                color = goldColor,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(2.dp))

        // Bottom small sparkle/indicator
        SparkleIcon(
            modifier = Modifier.size(6.dp),
            color = goldColor
        )
    }
}

@Composable
fun SparkleIcon(
    modifier: Modifier = Modifier,
    color: Color
) {
    androidx.compose.foundation.Canvas(modifier = modifier) {
        val path = androidx.compose.ui.graphics.Path().apply {
            moveTo(size.width / 2f, 0f)
            quadraticTo(size.width / 2f, size.height / 2f, size.width, size.height / 2f)
            quadraticTo(size.width / 2f, size.height / 2f, size.width / 2f, size.height)
            quadraticTo(size.width / 2f, size.height / 2f, 0f, size.height / 2f)
            quadraticTo(size.width / 2f, size.height / 2f, size.width / 2f, 0f)
            close()
        }
        drawPath(path = path, color = color)
    }
}

@Preview
@Composable
fun DiscoverNavigationItemPreview() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        DiscoverNavigationItem()
    }
}
