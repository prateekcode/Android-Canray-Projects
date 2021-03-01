package com.example.androiddevchallenge.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.purple200

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth().padding(15.dp)
    ) {
        Text(
            text = "Pupdopt",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.surface
        )
    }
}






