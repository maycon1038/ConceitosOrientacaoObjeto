package Abstracao

abstract class Funcionario(
    val nome: String, val cpf: String, val salarioBase: Double
) {
    // Método abstrato - deve ser implementado pelas subclasses
     abstract fun calcularSalario(): Double
    // PROPRIEDADE ABSTRATA - cada subclasse deve implementar
      abstract val funcao: String


    // Método concreto - já tem implementação
    fun exibirDados() {
        println("Função: $funcao")
        println("Nome: $nome")
        println("CPF: $cpf")
        println("Salário: R$ ${calcularSalario()}")
    }
}

