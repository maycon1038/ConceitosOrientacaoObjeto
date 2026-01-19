package Polimorfismo

class Triangulo(val base: Double, val altura: Double) : Forma() {

    override val nome: String = "Triangulo"

    override fun calcularArea(): Double {
        return (base * altura) / 2
    }

    override fun calcularPerimetro(): Double {
        // Para simplificar, considerando triângulo equilátero
        return base * 3
    }
}