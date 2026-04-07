package com.n1cks.starwarstest.features.peoplelist.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.n1cks.starwarstest.features.peoplelist.component.PeopleListComponent
import com.n1cks.starwarstest.features.peoplelist.state.PeopleListState

@Composable
fun PeopleListScreen(component: PeopleListComponent) {

    val state by component.state.subscribeAsState()

    when (val currentState = state) {

        is PeopleListState.Loading -> {
            CircularProgressIndicator()
        }

        is PeopleListState.Empty -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No Data")
            }
        }

        is PeopleListState.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Error: ${(state as PeopleListState.Error).message}")
            }
        }

        is PeopleListState.Data -> {
            LazyColumn {
                items(currentState.people) {person ->
                    Text(
                        text = person.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                component.onPersonClick(person.id)
                            }
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}