package com.example.semestralna_praca_vamz

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented IntagramUser, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under IntagramUser.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.semestralna_praca_vamz", appContext.packageName)
    }
}
