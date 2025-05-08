package org.utl.introkotlin_901.temasKotlin

import kotlin.math.PI
import kotlin.math.tan

fun main() {
    var opcion: Int
    do {
        println("Escoge la figura  ")
        println("1. Círculo")
        println("2. Cuadrado")
        println("3. Triángulo")
        println("4. Pentágono")
        println("5. Salir")
        print("Elige una opción: ")

        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                print("Ingresa el radio: ")
                val radio = readln().toDouble()
                    val area = PI * radio * radio
                    println("Área del círculo: ${area}")
                    println("Radio inválido")
                }

            2 -> {

                print("Ingresa el lado: ")
                val lado = readln().toDouble()
                val area = lado * lado
                println("Área del cuadrado: $area")

            }
            3 -> {

                print("Ingresa la base: ")
                val base = readln().toDouble()
                print("Ingresa la altura: ")
                val altura = readln().toDouble()
                    val area = (base * altura) / 2
                    println("Área del triángulo: $area")

            }
            4 -> {

                print("Ingresa el lado: ")
                val lado = readln().toDouble()
                    val area = (5 * lado * lado) / (4 * tan(PI / 5))
                    println("Área del pentágono: ${area}")

            }
            5 -> println("Saliste del programa ")
            else -> println("Opción no válida")
        }
    } while (opcion != 5)
}