package com.example.androiddevchallenge.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.*

@Composable
fun PuppyListDogCard(puppy: Puppy) {
    Card(
        modifier = Modifier
            .border(width = 0.5.dp, color = lightGrey, shape = RoundedCornerShape(7.dp)),
        elevation = 13.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(RectangleShape)
                    .border(
                        width = 2.dp,
                        color = getBackgroundColor(),
                        shape = RoundedCornerShape(7.dp)
                    )
            ) {
                val image: Painter = painterResource(id = puppy.image)
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(6.dp)
                        .clip(RoundedCornerShape(7.dp))
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = puppy.name,
                        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                        color = getBackgroundColor()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(color = genderColor(gender = puppy.gender).copy(0.2f))
                        ) {
                            Icon(
                                imageVector = getGenderIcon(gender = puppy.gender),
                                contentDescription = "Gender",
                                modifier = Modifier.padding(4.dp),
                                tint = genderColor(gender = puppy.gender)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    text = "${puppy.age} yrs",
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium),
                )
                Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.padding(top = 3.dp)) {
                    val icon: ImageVector = Icons.Default.LocationOn
                    Icon(
                        imageVector = icon,
                        contentDescription = "Location",
                        modifier = Modifier.size(16.dp, 16.dp),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.padding(start = 2.dp))
                    Text(
                        text = puppy.address,
                        style = MaterialTheme.typography.caption
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Chip(content = puppy.type)
                    }

                }
            }

        }
    }
}

fun genderColor(gender: String): Color {
    return if (gender == "Male") male else female
}


fun getBackgroundColor(): Color {
    val colorsList = listOf(red, green, blue, orange)
    return colorsList.random()
}

fun getGenderIcon(gender: String): ImageVector {
    return if (gender == "Male") Icons.Default.Male else Icons.Default.Female
}





























