package Abstracao

// Implementação concreta da abstração
class Gerente(
    nome: String,
    cpf: String,
    salarioBase: Double,
    val bonus: Double
) : Funcionario(nome, cpf, salarioBase), Autenticavel, Trabalhavel {

    override val senha: String = "123456" // Em um caso real, seria hash
    // IMPLEMENTAÇÃO DA PROPRIEDADE ABSTRATA
    override val funcao: String = "Gerente"

    override fun calcularSalario(): Double {
        return salarioBase + bonus
    }

    override fun autenticar(senha: String): Boolean {
        return this.senha == senha
    }

    override fun trabalhar() {
        println("$nome está gerenciando a equipe")
    }

    override fun fazerPausa() {
        println("$nome está fazendo uma pausa para café")
    }
}