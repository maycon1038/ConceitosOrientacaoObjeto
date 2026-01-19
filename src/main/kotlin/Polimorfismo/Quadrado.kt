package Polimorfismo

// Classe que implementa múltiplos comportamentos
class Quadrado(val lado: Double) : Forma(), Desenhavel {

    override val nome: String = "Quadrado"

    override fun calcularArea(): Double = lado * lado
    override fun calcularPerimetro(): Double = 4 * lado

    override fun desenhar() {
        println("Desenhando Quadrado de lado $lado")
    }

    override fun redimensionar(escala: Double) {
        println("Redimensionando Quadrado para ${lado * escala}")
    }
}