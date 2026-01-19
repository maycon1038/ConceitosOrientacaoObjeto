package Polimorfismo

class Circulo(val raio: Double) : Forma() {

    override val nome: String = "Circulo"

    override fun calcularArea(): Double {
        return Math.PI * raio * raio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * raio
    }

    // Sobrecarga de método (overloading) - outro tipo de polimorfismo
    fun calcularArea(pi: Double): Double {
        return pi * raio * raio
    }
}