package org.utl.introkotlin_901.temasKotlin

fun  main(){
    println("Hola Mundo ")


    val nombre ="rondald"
    var apellido:String="Diego"
    println(nombre+ ""+apellido)
    println("Hola $nombre $apellido")
    var num1 = 10
    println("La suma de $num1 + 5 = ${num1 + 5}")

    num1+= 5
    num1+=4
    num1++
    println(num1)

    var suelo:Float = 10000.0f
    var precio:Double = 20.5
    val mayorEdad:Boolean = true
    val estadoCivil:Char = 'S'
}