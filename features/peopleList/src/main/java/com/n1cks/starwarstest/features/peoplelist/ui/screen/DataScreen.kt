package com.n1cks.starwarstest.features.peoplelist.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.n1cks.starwarstest.core.domain.model.Person

@Composable
fun DataScreen(
    modifier: Modifier = Modifier,
    people: List<Person>,
    onPersonClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(people) { person ->
            Text(
                text = person.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onPersonClick(person.id)
                    }
                    .padding(16.dp)
            )
        }
    }
}