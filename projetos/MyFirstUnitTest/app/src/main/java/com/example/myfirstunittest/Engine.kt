package com.example.myfirstunittest

data class Engine (
    val cubicCentimeters: Int,
    val horsepower: Int,
    var temperature: Int,
    var isTurnedOn: Boolean

) {
    fun turnOn() {
        isTurnedOn = true
        temperature = 95
    }
    fun turnOff() {
        isTurnedOn = false
        temperature = 15
    }
}