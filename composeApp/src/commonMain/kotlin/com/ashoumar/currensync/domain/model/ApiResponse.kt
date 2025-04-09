package com.ashoumar.currensync.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val metadata: MetaData,
    val data:Map<String, Currency>
)

@Serializable
data class MetaData(
    val lastUpdatedAt: String
)

@Serializable
data class Currency(
    val code : String,
    val value : Double
)