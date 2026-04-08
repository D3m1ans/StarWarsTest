package com.n1cks.starwarstest.features.peoplelist.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.features.peoplelist.ui.item.PersonItem

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
            PersonItem(
                person = person,
                onPersonClick = { onPersonClick(person.id) }
            )
        }
    }
}