package Polimorfismo

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

/*Polimorfismo: Capacidade de objetos diferentes responderem à mesma mensagem de formas diferentes:
* Conseguimos através de herança, interfaces e overloading */


// Uso do polimorfismo
fun main() {
    // Forçar UTF-8 no programa
    // Forçar UTF-8 no console de saída
      System.setOut(java.io.PrintStream(System.`out`, true, "UTF-8"))


    val formas: List<Forma> = listOf(
        Retangulo(5.0, 3.0),
        Circulo(4.0),
        Triangulo(6.0, 4.0),
        Quadrado(5.0)
    )

    // Mesma interface, comportamentos diferentes
    formas.forEach { forma ->
        println("Forma: ${forma.nome}")
        println("Área: ${forma.calcularArea()}")
        println("Perímetro: ${forma.calcularPerimetro()}")
        forma.descricao()
        println()
    }

    // Polimorfismo com interface
    val quadrado = Quadrado(5.0)
    val retangulo =  Retangulo(5.0, 3.0)
    val desenhaveis: List<Desenhavel> = listOf(quadrado, retangulo)
    desenhaveis.forEach { it.desenhar() }

    // Overloading (sobrecarga)
    val circulo = Circulo(5.0)
    println("Circulo com Math.PI: ${circulo.calcularArea()}")
    println("Circulo com 3.14: ${circulo.calcularArea(3.14)}")

}