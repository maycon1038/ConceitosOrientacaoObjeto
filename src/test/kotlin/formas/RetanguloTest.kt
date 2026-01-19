package formas

import Polimorfismo.Retangulo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RetanguloTest {



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
    @DisplayName("Verifica se o nome da forma é Retângulo")
    fun getNome() {
        val retangulo = Retangulo(4.0, 6.0)
        assertEquals("Retangulo", retangulo.nome, "O nome da forma deveria ser Retângulo")
    }

    @Test
    @DisplayName("Verifica se a área é calculada corretamente")
    fun calcularArea() {
        val retangulo = Retangulo(5.0, 8.0)
        assertEquals(40.0, retangulo.calcularArea(), "A área do retângulo deveria ser largura * altura")
    }

    @Test
    @DisplayName("Verifica se o perímetro é calculado corretamente")
    fun calcularPerimetro() {
        val retangulo = Retangulo(3.0, 7.0)
        assertEquals(20.0, retangulo.calcularPerimetro(), "O perímetro do retângulo deveria ser 2 * (largura + altura)")
    }

    @Test
    @DisplayName("Verifica a saída de desenhar o retângulo")
    fun desenhar() {
        val retangulo = Retangulo(6.0, 4.0)
        val output = captureOutput {
            retangulo.desenhar()
        }
        assertEquals(
            "Desenhando Retangulo de largura 6.0 e altura 4.0\n",
            output
        )
    }

    @Test
    @DisplayName("Verifica a saída ao redimensionar o retângulo")
    fun redimensionar() {
        val retangulo = Retangulo(8.0, 5.0)
        val output = captureOutput {
            retangulo.redimensionar(2.0)
        }
        assertEquals(
            "Redimensionando Retangulo para largura 16.0 e altura 10.0\n",
            output
        )
    }

    @Test
    @DisplayName("Verifica se o valor da largura é retornado corretamente")
    fun getLargura() {
        val retangulo = Retangulo(7.0, 3.0)
        assertEquals(7.0, retangulo.largura, "O valor da largura deveria ser retornado corretamente")
    }

    @Test
    @DisplayName("Verifica se o valor da altura é retornado corretamente")
    fun getAltura() {
        val retangulo = Retangulo(7.0, 3.0)
        assertEquals(3.0, retangulo.altura, "O valor da altura deveria ser retornado corretamente")
    }

}