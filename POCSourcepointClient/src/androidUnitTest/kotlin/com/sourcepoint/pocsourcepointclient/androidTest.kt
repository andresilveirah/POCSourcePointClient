package com.sourcepoint.pocsourcepointclient

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidSourcepointCoordinatorTest {
    private var coordinator = SourcepointCoordinator(MockPlatform())

    @Test
    fun testExample() = runTest {
        assertTrue("Check MetaData is mentioned", coordinator.greet().contains("MetaData"))
    }
}