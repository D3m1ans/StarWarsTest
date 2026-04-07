package com.n1cks.starwarstest.root.config

import kotlinx.serialization.Serializable
@Serializable
sealed class RootConfig {
    @Serializable
    object PeopleList: RootConfig()

    @Serializable
    data class PersonDetails(val id: String): RootConfig()
}