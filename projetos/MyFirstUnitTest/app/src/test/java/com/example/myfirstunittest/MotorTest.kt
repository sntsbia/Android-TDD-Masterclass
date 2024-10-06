package com.example.myfirstunittest

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class MotorTest {

    private val motor = Motor(2000, 189, 15, false)

    @Test
    fun motorLigar() {
        motor.ligar()

        assertEquals(true, motor.ligado)
        assertEquals(95,motor.temperatura)
    }

    @Test
    fun motorDesligar() {
        motor.ligar()

        motor.desligar()

        assertEquals(false, motor.ligado)
        assertEquals(15, motor.temperatura)
    }

}