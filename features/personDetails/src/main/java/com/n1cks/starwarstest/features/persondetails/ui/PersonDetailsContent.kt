package com.n1cks.starwarstest.features.persondetails.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.n1cks.starwarstest.features.persondetails.component.PersonDetailsComponent
import com.n1cks.starwarstest.features.persondetails.state.PersonDetailsState
import com.n1cks.starwarstest.features.persondetails.ui.screen.DataScreen
import com.n1cks.starwarstest.features.persondetails.ui.screen.ErrorScreen
import com.n1cks.starwarstest.features.shared.R
import com.n1cks.starwarstest.features.shared.screen.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailsScreen(component: PersonDetailsComponent) {

    val state by component.state.subscribeAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = when(val s = state) {
                            is PersonDetailsState.Data -> s.person.name
                            else -> "Loading"
                        }
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = component::onBackClick
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_left_button),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        when (val currentState = state) {

            is PersonDetailsState.Loading -> {
                LoadingScreen(
                    modifier = Modifier.padding(paddingValues)
                )
            }

            is PersonDetailsState.Error -> {
                ErrorScreen(
                    modifier = Modifier.padding(paddingValues),
                    message = currentState.message,
                    onBackClick = component::onBackClick
                )
            }

            is PersonDetailsState.Data -> {
                DataScreen(
                    state = currentState,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}