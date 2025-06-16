package com.example.outsideintddexample.model

import android.util.Log

class Engine(
    var temperature: Int = 15, var isTurnedOn: Boolean = false
) {


    fun turnOn() {
        isTurnedOn = true

        Thread.sleep(6000) // Simulate time taken to turn on

        temperature = 95

        Log.d("Engine", "Engine turned on, temperature is now $temperature")

    }

}