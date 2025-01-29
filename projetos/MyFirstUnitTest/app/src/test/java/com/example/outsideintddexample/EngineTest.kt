package com.example.outsideintddexample

import org.junit.Assert.assertEquals
import org.junit.Test

class EngineTest {

    private val engine = Engine(2000, 189, 15, false)

    @Test
    fun engineTurnOn() {
        engine.turnOn()

        assertEquals(true, engine.isTurnedOn)
        assertEquals(95,engine.temperature)
    }

    @Test
    fun engineTurnOff() {
        engine.turnOn()

        engine.turnOff()

        assertEquals(false, engine.isTurnedOn)
        assertEquals(15, engine.temperature)
    }

}