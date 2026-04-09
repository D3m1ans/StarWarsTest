package com.n1cks.starwarstest.features.persondetails.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.n1cks.starwarstest.features.persondetails.state.PersonDetailsState
import com.n1cks.starwarstest.features.persondetails.ui.item.InfoItem

@Composable
fun DataScreen(
    state: PersonDetailsState.Data,
    modifier: Modifier = Modifier
) {
    val person = state.person
    val planet = state.planet

    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        item {
            Text("Basic Information", style = MaterialTheme.typography.titleMedium)
        }

        item { InfoItem("Height", person.height) }
        item { InfoItem("Mass", person.mass) }
        item { InfoItem("Hair Color", person.hairColor) }
        item { InfoItem("Skin Color", person.skinColor) }
        item { InfoItem("Eye Color", person.eyeColor) }
        item { InfoItem("Birth Year", person.birthYear) }
        item { InfoItem("Gender", person.gender) }

        item {
            Text("Homeworld", style = MaterialTheme.typography.titleMedium)
        }

        item { InfoItem("Name", planet.name) }
        item { InfoItem("Climate", planet.climate) }
        item { InfoItem("Terrain", planet.terrain) }
        item { InfoItem("Population", planet.population) }
    }
}