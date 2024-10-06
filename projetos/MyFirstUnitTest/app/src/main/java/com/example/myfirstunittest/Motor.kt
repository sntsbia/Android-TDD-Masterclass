package com.example.myfirstunittest

class Motor (
    val centimetrosCubicos: Int,
    val cavalosPotencia: Int,
    var temperatura: Int,
    var ligado: Boolean

) {
    fun ligar() {
        ligado = true
        temperatura = 95
    }
    fun desligar() {
        ligado = false
        temperatura = 15
    }
}