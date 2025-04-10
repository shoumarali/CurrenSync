package com.ashoumar.currensync

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import com.ashoumar.currensync.di.initializeKoin
import com.ashoumar.currensync.presentation.screen.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    initializeKoin()

    MaterialTheme {
        Navigator(HomeScreen())
    }
}