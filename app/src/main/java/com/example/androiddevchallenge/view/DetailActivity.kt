package com.example.androiddevchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PupList
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.*
import com.example.androiddevchallenge.utils.genderColor
import com.example.androiddevchallenge.utils.getGenderIcon

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val index = intent.extras?.getInt("index") ?: 0
        val puppy = PupList.getPetsData()[index]
        actionBar?.title = puppy.name
        setContent {
            MyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BodyDetailContent(dog = puppy)
                }
            }
        }
    }
}


@Composable
fun BodyDetailContent(dog: Puppy) {
    val context = LocalContext.current
    val typography = MaterialTheme.typography
    Column {
        val image: Painter = painterResource(id = dog.image)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = dog.name,
                        style = typography.h5.copy(fontWeight = FontWeight.Bold),
                        color = blue
                    )
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.padding(top = 3.dp)
                    ) {
                        val icon: ImageVector = Icons.Default.LocationOn
                        Icon(
                            imageVector = icon,
                            contentDescription = "Location",
                            modifier = Modifier.size(18.dp, 18.dp),
                            tint = Color.Red
                        )
                        Spacer(modifier = Modifier.padding(start = 2.dp))
                        Text(
                            text = dog.address,
                            style = MaterialTheme.typography.body1
                        )

                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                )
                {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(color = genderColor(gender = dog.gender).copy(0.2f))
                    ) {
                        Icon(
                            imageVector = getGenderIcon(gender = dog.gender),
                            contentDescription = "Gender",
                            modifier = Modifier.padding(8.dp),
                            tint = genderColor(gender = dog.gender)
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Card(backgroundColor = blue, elevation = 10.dp) {
                    Text(
                        text = dog.type,
                        modifier = Modifier.padding(
                            top = 15.dp,
                            bottom = 15.dp,
                            start = 30.dp,
                            end = 30.dp
                        ),
                        fontWeight = FontWeight.Bold,
                        color = white
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(backgroundColor = green, elevation = 10.dp) {
                    Text(
                        text = "${dog.age} Yrs",
                        modifier = Modifier.padding(
                            top = 15.dp,
                            bottom = 15.dp,
                            start = 30.dp,
                            end = 30.dp
                        ),
                        fontWeight = FontWeight.Bold,
                        color = white
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text("DESCRIPTION:", fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(12.dp))
            Card(backgroundColor = blue, elevation = 5.dp) {
                Text(
                    dog.description,
                    fontWeight = FontWeight.Bold,
                    color = blueBG,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1F))
            Box(modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = blue)
                .clickable {
                    Toast
                        .makeText(context, "Thanks for Adopting Me!", Toast.LENGTH_SHORT)
                        .show()
                }) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Pets,
                        contentDescription = "Paw Icon",
                        tint = red
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "Adopt",
                        style = MaterialTheme.typography.button,
                        color = white
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}