package com.example.androiddevchallenge.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.components.Header
import com.example.androiddevchallenge.components.PuppyListDogCard
import com.example.androiddevchallenge.data.PupList
import com.example.androiddevchallenge.model.Puppy

@Composable
fun HomeLayout() {
    Scaffold(
        topBar = { Header() }
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            itemsIndexed(PupList.getPetsData()) { index, pet ->
                ListItem(pet, index)
            }
        }
    }
}


//List Items
@Composable
fun ListItem(puppy: Puppy, index: Int) {
    val typography = MaterialTheme.typography
    Card(
        modifier = Modifier
            .padding(top = 10.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column {
            PuppyListDogCard(puppy = puppy, onClick = { /*TODO*/ })
        }
    }
}