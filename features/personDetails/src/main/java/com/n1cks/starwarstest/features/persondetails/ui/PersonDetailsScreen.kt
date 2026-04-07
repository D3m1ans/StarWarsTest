package com.n1cks.starwarstest.features.persondetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.n1cks.starwarstest.features.persondetails.component.PersonDetailsComponent
import com.n1cks.starwarstest.features.persondetails.state.PersonDetailsState

@Composable
fun PersonDetailsScreen(component: PersonDetailsComponent) {

    val state by component.state.subscribeAsState()

    when (val currentState = state) {
        is PersonDetailsState.Loading -> {
            CircularProgressIndicator()
        }

        is PersonDetailsState.Error -> {
            Column {
                Text("Error: ${currentState.message}")
                Button(onClick = component::onBackClick) {
                    Text("Back")
                }
            }
        }

        is PersonDetailsState.Data -> {
            val person = currentState.person
            val planet = currentState.planet

            Column(modifier = Modifier.padding(16.dp)) {

                Text(text = person.name, style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(8.dp))

                Text("Height: ${person.height}")
                Text("Mass: ${person.mass}")
                Text("Gender: ${person.gender}")

                Spacer(modifier = Modifier.height(16.dp))

                Text("Homeworld:", style = MaterialTheme.typography.titleMedium)

                Text("Name: ${planet.name}")

                Spacer(modifier = Modifier.height(24.dp))

                Button(onClick = component::onBackClick) {
                    Text("Back")
                }
            }
        }
    }
}