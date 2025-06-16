package com.example.outsideintddexample.acceptanceTests

import com.example.outsideintddexample.model.Car
import com.example.outsideintddexample.model.Engine
import com.example.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class CarFeature {

    private val engine = Engine()

    private val car = Car(
        engine,
        6.0
    )

    @get:Rule
    var testCoroutineScopeRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runTest {

        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() = runTest {

        car.turnOn()

        testScheduler.advanceTimeBy(6001)

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)

    }

}