package Abstracao

/*Abstracao: Foco no essencial, ocultando detalhes de implementação:
*Implementamos com classes abstract e interface */
// Classe abstrata - não pode ser instanciada diretamente

// Uso da abstração
fun main() {
    // Não pode instanciar classe abstrata
    // val funcionario = Funcionario("João", "123", 1000.0) // ERRO!

    val gerente = Gerente("Maria", "456.789.123-00", 8000.0, 2000.0)
    val desenvolvedor = Desenvolvedor("Carlos", "987.654.321-00", 5000.0, 24, "Kotlin")



    val funcionarios: List<Funcionario> = listOf(gerente, desenvolvedor)

    funcionarios.forEach { funcionario ->
        funcionario.exibirDados()
        funcionario.calcularSalario()
        println()
    }

    // Trabalhando com interfaces
    val trabalhadores: List<Trabalhavel> = listOf(gerente, desenvolvedor)
    trabalhadores.forEach {
        it.trabalhar()
        println()
    }


    val resultado1 = ResultadoOperacao.Sucesso("Operação concluída", 200)


    // Uso da classe selada (abstração com casos limitados)
    fun processarResultado(resultado: ResultadoOperacao) {
        when (resultado) {
            is ResultadoOperacao.Sucesso -> println("Sucesso: ${resultado.mensagem}")
            is ResultadoOperacao.Erro -> println("Erro: ${resultado.mensagem}")
              ResultadoOperacao.Carregando -> println("Carregando...")
        }
    }


    processarResultado(resultado1)
}