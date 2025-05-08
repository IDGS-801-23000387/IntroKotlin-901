package org.utl.introkotlin_901.temasKotlin

fun main(){

    var dias: List<String> = listOf("Lunes", "Martes", "Miercoles","Jueves","Viernes")
    println(dias)
    println("El primer dia es ${dias[0]}")
    println(" El primer dia es ${dias.first()}")
    println("El numero de dias es:${dias.count()}")
    println("El numero de dias es :${dias.size}")

    var figuras: MutableList<String> = mutableListOf("Circulo", "Cuadrado", "Triangulo")
    println(figuras)
    figuras.add("Pentagono")
    println(figuras)
    figuras.removeAt(0)
    println(figuras)
    figuras.remove("Cuadrado")
    println(figuras)


    val frutas = mapOf("Manzana" to 1500, "Platano" to 1400)
    println(frutas)
    println(frutas["Manzana"])
    println(frutas.keys)
    println(frutas.values)
}