package com.example.outsideintddexample.model

import android.util.Log
import kotlinx.coroutines.delay

class Engine(
    var temperature: Int = 15, var isTurnedOn: Boolean = false
) {

    suspend fun turnOn() {
        isTurnedOn = true

        delay(6000) // Simulate time taken to turn on

        temperature = 95

        Log.d("Engine", "Engine turned on, temperature is now $temperature")

    }

}