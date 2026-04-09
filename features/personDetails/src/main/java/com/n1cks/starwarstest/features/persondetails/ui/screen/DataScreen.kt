package com.n1cks.starwarstest.features.persondetails.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.n1cks.starwarstest.features.persondetails.state.PersonDetailsState
import com.n1cks.starwarstest.features.persondetails.ui.item.InfoItem
import com.n1cks.starwarstest.features.persondetails.ui.item.infoSection

@Composable
fun DataScreen(
    state: PersonDetailsState.Data,
    modifier: Modifier = Modifier
) {
    val person = state.person
    val planet = state.planet
    val species = state.species
    val films = state.films

    val personInfo = listOf(
        "Height" to person.height,
        "Mass" to person.mass,
        "Hair Color" to person.hairColor,
        "Skin Color" to person.skinColor,
        "Eye Color" to person.eyeColor,
        "Birth Year" to person.birthYear,
        "Gender" to person.gender
    )

    val planetInfo = listOf(
        "Name" to planet.name,
        "Climate" to planet.climate,
        "Terrain" to planet.terrain,
        "Population" to planet.population
    )

    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {

        infoSection("Basic Information", personInfo)

        infoSection("Homeworld", planetInfo)

        item {
            Text("Species", style = MaterialTheme.typography.titleMedium)
        }

        if (species.isNotEmpty()) {
            items(species) {
                InfoItem(it.name, "")
            }
        } else {
            item {
                InfoItem("", "No species information available")
            }
        }

        item {
            Text("Films", style = MaterialTheme.typography.titleMedium)
        }

        items(films) {
            InfoItem(it.title, it.openingCrawl)
        }
    }
}