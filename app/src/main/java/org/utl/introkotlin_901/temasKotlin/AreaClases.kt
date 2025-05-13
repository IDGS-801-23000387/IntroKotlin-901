package org.utl.introkotlin_901.temasKotlin

class Circulo(var radio: Double) {
    fun calcularArea(): Double {
        val pi = 3.1416
        return pi * radio * radio
    }
}


class Cuadrado(var lado: Double) {
    fun calcularArea(): Double {
        return lado * lado
    }
}


class Triangulo(var base: Double, var altura: Double) {
    fun calcularArea(): Double {
        return (base * altura) / 2
    }
}


class Pentagono(var lado: Double) {
    fun calcularArea(): Double {
        val tan = 0.7265
        return (5 * lado * lado) / (4 * tan )
    }
}

// Función principal
fun main() {
    var opcion: Int

    do {

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
                val circulo = Circulo(radio)
                println("Área del círculo: " + circulo.calcularArea())
            }

            2 -> {
                print("Ingresa el lado: ")
                val lado = readln().toDouble()
                val cuadrado = Cuadrado(lado)
                println("Área del cuadrado: " + cuadrado.calcularArea())
            }

            3 -> {
                print("Ingresa la base: ")
                val base = readln().toDouble()
                print("Ingresa la altura: ")
                val altura = readln().toDouble()
                val triangulo = Triangulo(base, altura)
                println("Área del triángulo: " + triangulo.calcularArea())
            }

            4 -> {
                print("Ingresa el lado: ")
                val lado = readln().toDouble()
                val pentagono = Pentagono(lado)
                println("Área del pentágono: " + pentagono.calcularArea())
            }

            5 -> println("Salir:)")

            else -> println("Opción no válida. Intenta otra vez.")
        }

    } while (opcion != 5)
}