package com.sourcepoint.pocsourcepointclient

import com.russhwolf.settings.Settings
import com.russhwolf.settings.NSUserDefaultsSettings
import platform.UIKit.UIDevice
import platform.Foundation.NSUserDefaults

actual abstract class Context

actual class PlatformSpecific : Platform {
    private val delegate: NSUserDefaults = NSUserDefaults()
    override val name = UIDevice.currentDevice.systemName()
    override val version: String = UIDevice.currentDevice.systemVersion
    override val settings: Settings = NSUserDefaultsSettings(delegate)
}