package com.sourcepoint.pocsourcepointclient

import com.russhwolf.settings.Settings

interface Platform {
    val name: String
    val version: String
    val settings: Settings
}

expect abstract class Context
expect class PlatformSpecific: Platform