package com.ashoumar.currensync.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import com.ashoumar.currensync.data.remote.api.CurrencyApiServiceImpl

class HomeScreen: Screen {

    @Composable
    override fun Content() {
        LaunchedEffect(Unit) {
//            CurrencyApiServiceImpl().getLatestExchangeRates()
        }
    }
}