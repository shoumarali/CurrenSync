package com.ashoumar.currensync.domain

interface PreferencesRepository {
    suspend fun saveLastUpdate(lastUpdated: String)
    suspend fun isDataFresh(currentTimeStamp: Long): Boolean
}