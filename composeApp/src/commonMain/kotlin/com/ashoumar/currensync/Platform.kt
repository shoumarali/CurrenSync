package com.ashoumar.currensync

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform