package org.utl.introkotlin_901.temasKotlin


import kotlin.math.sqrt

fun main() {
    var correcto: Boolean

    do {
        correcto = true

        println("Ingresa el valor de a:")
        val a = readln().toDouble() // Use toDoubleOrNull for safer input
        if (a == null || a == 0.0) {
            println("El valor de 'a' no puede ser 0. No es una ecuación de segundo grado.")
            correcto = false
            continue
        }

        println("Ingresa el valor de b:")
        val b = readln().toDouble()
        if (b == null) {
            println("Entrada inválida para 'b'.")
            correcto = false
            continue
        }

        println("Ingresa el valor de c:")
        val c = readln().toDoubleOrNull()
        if (c == null) {
            println("Entrada inválida para 'c'.")
            correcto = false
            continue
        }


        val discriminante = (b * b) - (4 * a * c)

        if (discriminante < 0) {
            println("La ecuación no tiene soluciones reales (el discriminante es negativo).")
            correcto = false
        } else if (discriminante == 0.0) { // Handle discriminant = 0
            val resultado = -b / (2 * a)
            println("La ecuación tiene una única solución real: x = $resultado")
        }
        else {
            val resultado1 = (-b + sqrt(discriminante)) / (2 * a)
            val resultado2 = (-b - sqrt(discriminante)) / (2 * a)

            println("Las soluciones reales son:")
            println("x1 = $resultado1")
            println("x2 = $resultado2")
        }

    } while (!correcto)
}