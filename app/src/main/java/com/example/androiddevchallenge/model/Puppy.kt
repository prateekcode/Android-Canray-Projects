package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class Puppy(
    val name: String,
    val age: String,
    val gender: String,
    val type: String,
    val description: String,
    val address: String,
    val image: Int,
)
