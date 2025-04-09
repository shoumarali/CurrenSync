package com.ashoumar.currensync.domain

import com.ashoumar.currensync.domain.model.Currency
import com.ashoumar.currensync.domain.model.RequestState

interface CurrencyApiService {
    suspend fun getLatestExchangeRates(): RequestState<List<Currency>>
}