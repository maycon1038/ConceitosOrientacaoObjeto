package Abstracao

class Desenvolvedor(
    nome: String,
    cpf: String,
    salarioBase: Double,
    val horasExtras: Int,
    val linguagem: String
) : Funcionario(nome, cpf, salarioBase), Trabalhavel {
    // IMPLEMENTAÇÃO DIFERENTE
    override val funcao: String = Cargo.DEV.name

    override fun calcularSalario(): Double {
        val valorHoraExtra = salarioBase / 160 // 160 horas mensais
        return salarioBase + (horasExtras * valorHoraExtra)
    }

    override fun trabalhar() {
        println("$nome está programando")
    }

    override fun fazerPausa() {
        println("$nome está jogando ping-pong")
    }
}