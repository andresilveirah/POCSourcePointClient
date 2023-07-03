package com.sourcepoint.pocsourcepointclient

import com.russhwolf.settings.Settings
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class MockPlatform : Platform {
    class MockSettings : Settings {
        override val keys: Set<String> = setOf()
        override val size = 0

        override fun clear() {}
        override fun getBoolean(key: String, defaultValue: Boolean): Boolean { return false }
        override fun getBooleanOrNull(key: String): Boolean? { return null }
        override fun getDouble(key: String, defaultValue: Double): Double { return 0.0 }
        override fun getDoubleOrNull(key: String): Double? { return null }
        override fun getFloat(key: String, defaultValue: Float): Float { return 0f }
        override fun getFloatOrNull(key: String): Float? { return null }
        override fun getInt(key: String, defaultValue: Int): Int { return 0 }
        override fun getIntOrNull(key: String): Int? { return null }
        override fun getLong(key: String, defaultValue: Long): Long { return 0 }
        override fun getLongOrNull(key: String): Long? { return null }
        override fun getString(key: String, defaultValue: String): String { return "" }
        override fun getStringOrNull(key: String): String? { return  null }
        override fun hasKey(key: String): Boolean { return true }
        override fun putBoolean(key: String, value: Boolean) {}
        override fun putDouble(key: String, value: Double) {}
        override fun putFloat(key: String, value: Float) {}
        override fun putInt(key: String, value: Int) {}
        override fun putLong(key: String, value: Long) {}
        override fun putString(key: String, value: String) {}
        override fun remove(key: String) {}
    }

    override val name = "Mock Platform"
    override val version = "0.0.1"
    override val settings = MockSettings()
}

class CommonGreetingTest {
    var coordinator = SourcepointCoordinator(MockPlatform())

    @Test
    fun testExample() = runTest {
        assertTrue(coordinator.greet().contains("meta-data"), "Check 'meta-data' is mentioned")
    }
}