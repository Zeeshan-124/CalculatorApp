package com.example.calculatorapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun CalButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    number: String = "0",
    size: TextUnit = 30.sp,
    background: Color = Color.White,
    color: Color = Color.Black
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable {
                onClick.invoke()
            }
            .then(modifier)
        ) {
            Text(
                text = number,
                fontSize = size,
                color = color
            )
        }
}
@Composable
fun Cal2Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    image: ImageVector = Icons.AutoMirrored.Outlined.Backspace,
    size: Dp = 30.dp,
    background: Color = Color.White,
    color: Color = Color.Black
    ) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable {
                onClick.invoke()
            }
            .then(modifier),
    ) {
        Icon(
            imageVector = image,
            contentDescription = "",
            modifier = Modifier
                .size(size),
            tint = color
            )
    }
}