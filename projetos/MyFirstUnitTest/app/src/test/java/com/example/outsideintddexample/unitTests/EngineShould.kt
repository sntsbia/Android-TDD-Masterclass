package com.example.outsideintddexample.unitTests

import com.example.outsideintddexample.model.Engine
import com.example.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @get:Rule
    var testCoroutineScopeRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runTest {

        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTemperatureWhenItTurnsOn() = runTest {
        engine.turnOn()

        assertEquals(95, engine.temperature)

    }

}