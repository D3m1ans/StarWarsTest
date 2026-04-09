package com.n1cks.starwarstest.features.shared.scope

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

fun ComponentContext.componentScope(): CoroutineScope {
    return coroutineScope(Dispatchers.Main.immediate + SupervisorJob())
}