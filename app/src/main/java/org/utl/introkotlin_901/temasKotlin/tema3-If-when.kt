package org.utl.introkotlin_901.temasKotlin

fun main(){
    val d:Int
    val e=true
    if (e){
        d=1

    }else{
        d=2
    }
    println(d)
val numero =if (e) 1 else 2
    println(numero)

    println("Ingrese el sueldo del empleado ")
    val sueldo = readln().toDouble()
    if (sueldo>300){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos ")
    }

    val objeto:Any="HOla"
    when(objeto){
        "1"-> println("Es un uno")
        "Hola"-> println("Es un saludo")
        is String-> println("Es un string")
        else-> println("No se que es ")
    }






}


