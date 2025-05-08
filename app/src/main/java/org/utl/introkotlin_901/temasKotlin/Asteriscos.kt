package org.utl.introkotlin_901.temasKotlin





    fun main() {
        var numFilas: Int

        do {
            println("Introduce el número de filas para la pirámide :")
            numFilas = readln().toInt()  // Read input and handle potential null

            if (numFilas > 0) {

                for (i in 1..numFilas) {

                    for (j in 1..(numFilas - i)) {
                        print(" ")
                    }

                    for (k in 1..i) {
                        print("*")
                    }

                    println()
                }
            } else if (numFilas < 0) {
                println("Entrada inválida")
            }

        } while (numFilas != 0)


    }

