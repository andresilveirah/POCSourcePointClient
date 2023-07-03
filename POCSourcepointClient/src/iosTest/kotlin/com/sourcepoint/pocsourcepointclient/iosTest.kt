package com.sourcepoint.pocsourcepointclient

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {
    private val coordinator = SourcepointCoordinator(PlatformSpecific())

    @Test
    fun testExample() = runTest {
        assertTrue(coordinator.greet().contains("hello world"), "Check iOS is mentioned")
    }
}