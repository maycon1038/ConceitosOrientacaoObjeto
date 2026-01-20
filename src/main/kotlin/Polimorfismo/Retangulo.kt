package Polimorfismo

// Implementações diferentes da mesma interface
class Retangulo(val largura: Double, val altura: Double) : Forma(), Desenhavel{

    override val nome: String = Figura.RETANGULO.name

    override fun calcularArea(): Double {
        return largura * altura
    }

    override fun calcularPerimetro(): Double {
        return 2 * (largura + altura)
    }

    override fun desenhar() {
        println("Desenhando Retangulo de largura $largura e altura $altura")
    }

    override fun redimensionar(escala: Double) {
        println("Redimensionando Retangulo para largura ${largura * escala} e altura ${altura * escala}")
    }
}