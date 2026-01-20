package pessoas

import Abstracao.Cargo
import Abstracao.Desenvolvedor
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class DesenvolvedorTest {


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
    @DisplayName("Deve retornar a função correta baseada na linguagem de programação")
    fun getFuncao() {
        val dev = Desenvolvedor("João", "123.456.789-00", 8000.0, 10, "Kotlin")
        assertEquals(Cargo.DEV.name, dev.funcao)
    }

    @Test
    @DisplayName("Deve calcular o salário corretamente com base nas horas extras")
    fun calcularSalario() {
        val dev = Desenvolvedor("João", "123.456.789-00", 8000.0, 20, "Java")
        val expectedSalary = 8000.0 + (8000.0 / 160 * 20)
        assertEquals(expectedSalary, dev.calcularSalario())
    }

    @Test
    @DisplayName("Deve exibir mensagem indicando que o desenvolvedor está programando")
    fun trabalhar() {
        val dev = Desenvolvedor("João", "123.456.789-00", 8000.0, 10, "Kotlin")
        val output = captureOutput {
            dev.trabalhar()
        }
        assertTrue(output.contains("João está programando"))
    }

    @Test
    @DisplayName("Deve exibir mensagem indicando que o desenvolvedor está fazendo pausa")
    fun fazerPausa() {
        val dev = Desenvolvedor("João", "123.456.789-00", 8000.0, 10, "Python")
        val output = captureOutput {
            dev.fazerPausa()
        }
        assertTrue(output.contains("João está jogando ping-pong"))
    }

    @Test
    @DisplayName("Deve retornar o número correto de horas extras")
    fun getHorasExtras() {
        val dev = Desenvolvedor("João", "123.456.789-00", 8000.0, 15, "JavaScript")
        assertEquals(15, dev.horasExtras)
    }

    @Test
    @DisplayName("Deve retornar a linguagem de programação correta")
    fun getLinguagem() {
        val dev = Desenvolvedor("João", "123.456.789-00", 8000.0, 10, "Scala")
        assertEquals("Scala", dev.linguagem)
    }

}