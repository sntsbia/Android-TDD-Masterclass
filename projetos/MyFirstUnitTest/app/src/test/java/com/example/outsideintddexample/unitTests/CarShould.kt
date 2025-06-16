package com.example.outsideintddexample.unitTests

import com.example.outsideintddexample.model.Car
import com.example.outsideintddexample.model.Engine
import com.example.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class CarShould {

    private val engine: Engine = mock()
    private var car = Car(engine, 5.0)

    @get:Rule
    var testCoroutineScopeRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn() = runTest {

        car.turnOn()

        assertEquals(4.5, car.fuel)

    }

    @Test
    fun turnOnItsEngine() = runTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}