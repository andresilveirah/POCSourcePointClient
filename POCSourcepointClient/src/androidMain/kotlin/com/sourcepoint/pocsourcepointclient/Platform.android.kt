package com.sourcepoint.pocsourcepointclient

import android.content.Context
import android.preference.PreferenceManager
import com.russhwolf.settings.SharedPreferencesSettings

actual typealias Context = android.content.Context

actual class PlatformSpecific(context: Context) : Platform {
    override val name = "Android"
    override val version = "${android.os.Build.VERSION.SDK_INT}"

    private val manager = PreferenceManager.getDefaultSharedPreferences(context)
    override val settings = SharedPreferencesSettings(manager)
}