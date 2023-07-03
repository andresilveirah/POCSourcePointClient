package com.sourcepoint.pocsourcepointclient

import kotlinx.datetime.*

class Date {
    fun today(): String {
        val todayDate = Clock.System.now()
        return todayDate.toString()
    }
}