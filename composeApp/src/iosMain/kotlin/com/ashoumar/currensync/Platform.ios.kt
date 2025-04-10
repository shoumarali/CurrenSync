package com.ashoumar.currensync

class IOSPlatform: Platform {
    override val name: String = "IOS"
}

actual fun getPlatform(): Platform = IOSPlatform()