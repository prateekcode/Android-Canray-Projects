package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.utils.getBackgroundColor

@Composable
fun Chip(content: String) {
    Text(
        text = content,
        style = typography.caption,
        color = white,
        modifier = Modifier
            .background(color = getBackgroundColor(), shape = RoundedCornerShape(5.dp))
            .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
    )
}