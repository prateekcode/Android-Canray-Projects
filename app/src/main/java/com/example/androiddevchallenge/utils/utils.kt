package com.example.androiddevchallenge.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevchallenge.ui.theme.*

fun genderColor(gender: String): Color {
    return if (gender == "Male") male else female
}


fun getBackgroundColor(): Color {
    val colorsList = listOf(red, green, blue)
    return colorsList.random()
}

fun getGenderIcon(gender: String): ImageVector {
    return if (gender == "Male") Icons.Default.Male else Icons.Default.Female
}
