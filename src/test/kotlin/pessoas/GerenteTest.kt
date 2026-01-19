package pessoas

import Abstracao.Gerente
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class GerenteTest {


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


    @Test
    @DisplayName("Deve retornar a senha correta do gerente")
    fun getSenha() {
        val gerente = Gerente("Maria", "456.789.123-00", 8000.0, 2000.0)
        assertEquals("123456", gerente.senha)
    }

    @Test
    @DisplayName("Deve retornar a função correta do gerente")
    fun getFuncao() {
        val gerente = Gerente("Maria", "456.789.123-00", 8000.0, 2000.0)
        assertEquals("Gerente", gerente.funcao)
    }

    @Test
    @DisplayName("Deve calcular o salário corretamente incluindo o bônus")
    fun calcularSalario() {
        val gerente = Gerente("Maria", "456.789.123-00", 8000.0, 2000.0)
        val expectedSalary = 8000.0 + 2000.0
        assertEquals(expectedSalary, gerente.calcularSalario())
    }

    @Test
    @DisplayName("Deve autenticar com sucesso quando a senha estiver correta")
    fun autenticar() {
        val gerente = Gerente("Maria", "456.789.123-00", 8000.0, 2000.0)
        assertTrue(gerente.autenticar("123456"))
        assertFalse(gerente.autenticar("senhaErrada"))
    }

    @Test
    @DisplayName("Deve exibir mensagem indicando que o gerente está gerenciando a equipe")
    fun trabalhar() {
        val gerente = Gerente("Maria", "456.789.123-00", 8000.0, 2000.0)
        val originalOut = captureOutput { gerente.trabalhar() }
        assertTrue(originalOut.contains("Maria está gerenciando a equipe"))
    }

    @Test
    @DisplayName("Deve exibir mensagem indicando que o gerente está fazendo pausa para café")
    fun fazerPausa() {
        val gerente = Gerente("Maria", "456.789.123-00", 8000.0, 2000.0)
        val originalOut = captureOutput { gerente.fazerPausa() }
        assertTrue(originalOut.contains("Maria está fazendo uma pausa para café"))
    }

    @Test
    @DisplayName("Deve retornar o valor correto do bônus")
    fun getBonus() {
        val gerente = Gerente("Maria", "456.789.123-00", 8000.0, 2000.0)
        assertEquals(2000.0, gerente.bonus)
    }

}