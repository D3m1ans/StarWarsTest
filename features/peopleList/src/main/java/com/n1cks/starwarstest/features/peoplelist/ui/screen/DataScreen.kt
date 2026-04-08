package com.n1cks.starwarstest.features.peoplelist.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.n1cks.starwarstest.core.domain.model.Person
import com.n1cks.starwarstest.features.peoplelist.ui.item.PersonItem
import com.n1cks.starwarstest.features.peoplelist.ui.item.SearchBar

@Composable
fun DataScreen(
    modifier: Modifier = Modifier,
    allPeople: List<Person>,
    filteredPeople: List<Person>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onPersonClick: (String) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        SearchBar(
            query = searchQuery,
            onQueryChange = onSearchQueryChange
        )

        if (searchQuery.isNotBlank()) {
            Text(
                text = "Найдено: ${filteredPeople.size} из ${allPeople.size}",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall
            )
        }

        LazyColumn {
            items(filteredPeople) { person ->
                PersonItem(
                    person = person,
                    onPersonClick = { onPersonClick(person.id) }
                )
            }
        }
    }
}