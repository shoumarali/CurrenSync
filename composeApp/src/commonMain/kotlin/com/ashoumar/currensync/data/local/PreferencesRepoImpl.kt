package com.ashoumar.currensync.data.local

import com.ashoumar.currensync.domain.PreferencesRepository
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.FlowSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalSettingsApi::class)
class PreferencesRepoImpl(
    private val settings: Settings
): PreferencesRepository{
    companion object{
        const val TIMESTAMP_KEY = "lastUpdated"
    }

    private val flowSettings : FlowSettings = (settings as ObservableSettings).toFlowSettings()

    override suspend fun saveLastUpdate(lastUpdated: String) {
        flowSettings.putLong(
            TIMESTAMP_KEY,
            Instant.parse(lastUpdated).toEpochMilliseconds()
        )
    }

    override suspend fun isDataFresh(currentTimeStamp: Long): Boolean {
        val savedTimestamp = flowSettings.getLong(
            TIMESTAMP_KEY,
            0L
        )
        return if(savedTimestamp != 0L){
            val currentInstant = Instant.fromEpochMilliseconds(currentTimeStamp)
            val savedInstant = Instant.fromEpochMilliseconds(savedTimestamp)

            val currentDateTime = currentInstant.toLocalDateTime(TimeZone.currentSystemDefault())
            val savedDateTime = savedInstant.toLocalDateTime(TimeZone.currentSystemDefault())

            val dayDifference = currentDateTime.date.dayOfYear - savedDateTime.date.dayOfYear
            dayDifference < 1
        }else
            false
    }
}