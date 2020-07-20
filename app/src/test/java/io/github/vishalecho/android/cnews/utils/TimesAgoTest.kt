package io.github.vishalecho.android.cnews.utils

import org.junit.Test

import org.junit.Assert.*

class TimesAgoTest {

    @Test
    fun secondAgo() {
    }

    @Test
    fun secondsAgo() {
    }

    @Test
    fun minuteAgo() {
    }

    @Test
    fun minutesAgo() {
    }

    @Test
    fun yearsAgo() {
        assertEquals("2 years ago", TimesAgo.get(1532853058))
    }
}