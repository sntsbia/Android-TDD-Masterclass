package com.example.outsideintddexample.model

class Car(
    private val engine: Engine, var fuel: Double
) {

    fun turnOn() {
        fuel -= 0.5
        engine.turnOn()
    }
}