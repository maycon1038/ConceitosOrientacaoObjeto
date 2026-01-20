package pessoas

import Abstracao.ResultadoOperacao
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.Test

class ResultadoOperacaoTest {


    // Função auxiliar para capturar a saída do console
    private fun captureOutput(block: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(outputStream))
        try {
            block()
        } finally {
            System.setOut(originalOut)
        }
        return outputStream.toString().replace("\r\n", "\n") // Normaliza quebras de linha
    }


    fun processarResultado(resultado: ResultadoOperacao) {
        when (resultado) {
            is ResultadoOperacao.Sucesso -> println("Sucesso: ${resultado.mensagem}")
            is ResultadoOperacao.Erro -> println("Erro: ${resultado.mensagem}")
            ResultadoOperacao.Carregando -> println("Carregando...")
        }
    }

    @Test
    @DisplayName("Deve retornar carregando ao iniciar a classe")
    fun carregando() {
        val resultado = ResultadoOperacao.Carregando
        assertTrue(resultado is ResultadoOperacao.Carregando)
        val originalOut = captureOutput { processarResultado(resultado) }
        assertTrue( originalOut.contains("Carregando..."))

    }


    @Test
    @DisplayName("Deve retornar sucesso quando operação for bem-sucedida")
    fun sucesso() {
        val resultado = ResultadoOperacao.Sucesso("Operação realizada com sucesso", 200)
        assertTrue(resultado is ResultadoOperacao.Sucesso)
        val originalOut = captureOutput { processarResultado(resultado) }
        assertTrue( originalOut.contains("Sucesso: Operação realizada com sucesso"))
        assertEquals(200, resultado.codigo)
    }

    @Test
    @DisplayName("Deve retornar Erro quando operação Falhar")
    fun error() {
        val resultado = ResultadoOperacao.Erro("Erro durante o processo", null)
        assertTrue(resultado is ResultadoOperacao.Erro)
        val originalOut = captureOutput { processarResultado(resultado) }
        assertTrue( originalOut.contains("Erro: Erro durante o processo"))
       // assertEquals(null, resultado.excecao)
    }

}