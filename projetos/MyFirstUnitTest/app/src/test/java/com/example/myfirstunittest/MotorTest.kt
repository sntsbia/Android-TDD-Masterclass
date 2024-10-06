package com.example.myfirstunittest

import org.junit.Test

class MotorTest {

    private val motor = Motor(2000, 189, 15, false)

    @Test
    fun motorLigado() {
        motor.ligar()

        assert(motor.ligado)

    }
}