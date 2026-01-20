package formas

import Polimorfismo.Figura
import Polimorfismo.Quadrado
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class QuadradoTest {



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
    @DisplayName("Verifica se o nome da forma é Quadrado")
    fun getNome() {
        val quadrado = Quadrado(4.0)
        assertEquals(Figura.QUADRADO.name, quadrado.nome, "O nome da forma deveria ser Quadrado")
    }

    @Test
    @DisplayName("Verifica se a área é calculada corretamente")
    fun calcularArea() {
        val quadrado = Quadrado(5.0)
        assertEquals(25.0, quadrado.calcularArea(), "A área do quadrado deveria ser lado * lado")
    }

    @Test
    @DisplayName("Verifica se o perímetro é calculado corretamente")
    fun calcularPerimetro() {
        val quadrado = Quadrado(3.0)
        assertEquals(12.0, quadrado.calcularPerimetro(), "O perímetro do quadrado deveria ser 4 * lado")
    }

    @Test
    @DisplayName("Verifica a saída de desenhar o quadrado")
    fun desenhar() {
        val quadrado = Quadrado(6.0)
        val output = captureOutput {
            quadrado.desenhar()
        }
        assertEquals(
            "Desenhando Quadrado de lado 6.0\n",
            output)
    }

    @Test
    @DisplayName("Verifica a saída ao redimensionar o quadrado")
    fun redimensionar() {
        val quadrado = Quadrado(8.0)
        val output = captureOutput {
            quadrado.redimensionar(2.0)
        }
        assertEquals(
            "Redimensionando Quadrado para 16.0\n",
            output)
    }

    @Test
    @DisplayName("Verifica se o valor do lado é retornado corretamente")
    fun getLado() {
        val quadrado = Quadrado(7.0)
        assertEquals(7.0, quadrado.lado, "O valor do lado deveria ser retornado corretamente")
    }

}