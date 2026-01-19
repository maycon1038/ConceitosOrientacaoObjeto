package Polimorfismo

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets



// Classe base abstrata
abstract class Forma {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
    abstract val nome: String
    // Método concreto com implementação
    fun descricao() {
        println("Esta é uma forma geométrica")
    }



}

