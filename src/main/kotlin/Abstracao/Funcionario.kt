package Abstracao

abstract class Funcionario(
    val nome: String, val cpf: String, val salarioBase: Double
) {
    // Método abstrato - deve ser implementado pelas subclasses
     abstract fun calcularSalario(): Double
    // PROPRIEDADE ABSTRATA - cada subclasse deve implementar
      abstract val funcao: String

      companion object {

          fun calcularImposto(salario: Double): Double {
              return salario * 0.2
          }
      }


    // Método concreto - já tem implementação
    fun exibirDados() {
        println("Função: $funcao")
        println("Nome: $nome")
        println("CPF: $cpf")
        println("Salário: R$ ${calcularSalario()}")
    }
}

