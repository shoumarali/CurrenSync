package com.ashoumar.currensync.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val meta: Meta,
    val data:Map<String, Currency>
)

@Serializable
data class Meta(
    val lastUpdatedAt: String
)

@Serializable
data class Currency(
    val code : String,
    val value : Double
)