package com.n1cks.starwarstest.features.peoplelist.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.n1cks.starwarstest.features.peoplelist.component.PeopleListComponent
import com.n1cks.starwarstest.features.peoplelist.state.PeopleListState
import com.n1cks.starwarstest.features.peoplelist.ui.screen.DataScreen
import com.n1cks.starwarstest.features.peoplelist.ui.screen.EmptyScreen
import com.n1cks.starwarstest.features.peoplelist.ui.screen.ErrorScreen
import com.n1cks.starwarstest.features.peoplelist.ui.screen.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleListContent(component: PeopleListComponent) {
    val state by component.state.subscribeAsState()

    var searchQuery by androidx.compose.runtime.remember {
        androidx.compose.runtime.mutableStateOf("")
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Star Wars Characters") }
            )
        }
    ) { paddingValues ->
        when (val currentState = state) {
            is PeopleListState.Loading -> {
                LoadingScreen(modifier = Modifier.padding(paddingValues))
            }
            is PeopleListState.Empty -> {
                EmptyScreen(modifier = Modifier.padding(paddingValues))
            }
            is PeopleListState.Error -> {
                ErrorScreen(
                    modifier = Modifier.padding(paddingValues),
                    message = currentState.message
                )
            }
            is PeopleListState.Data -> {
                DataScreen(
                    modifier = Modifier.padding(paddingValues),
                    allPeople = currentState.allPeople,
                    filteredPeople = currentState.filteredPeople,
                    searchQuery = searchQuery,
                    onSearchQueryChange = { query ->
                        searchQuery = query
                        component.onSearchQueryChanged(query)
                    },
                    onPersonClick = component::onPersonClick
                )
            }
        }
    }
}