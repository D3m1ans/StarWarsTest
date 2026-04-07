package com.n1cks.starwarstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.n1cks.starwarstest.root.content.RootContent
import com.n1cks.starwarstest.root.factory.ComponentFactory
import com.n1cks.starwarstest.ui.theme.StarWarsTestTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val componentFactory: ComponentFactory by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent = componentFactory.createRootComponent(
            componentContext = defaultComponentContext()
        )

        enableEdgeToEdge()
        setContent {
            StarWarsTestTheme {
                RootContent(
                    component = rootComponent
                )
            }
        }
    }
}
