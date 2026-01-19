package formas

import Polimorfismo.Triangulo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test // Ou org.junit.Test para JUnit 4
import kotlin.test.assertEquals


class TrianguloTest {

    @Test
    @DisplayName("Verifica o nome retornado pelo método getNome é 'Triangulo'")
    fun getNome() {
        val triangulo = Triangulo(6.0, 4.0)
        assertEquals("Triangulo", triangulo.nome)
    }

    @Test
    @DisplayName("Calcula a área do triângulo")
    fun calcularArea() {
        val triangulo = Triangulo(6.0, 4.0)
        val areaEsperada = (6.0 * 4.0) / 2
        assertEquals(areaEsperada, triangulo.calcularArea())
    }

    @Test
    @DisplayName("Calcula o perímetro do triângulo")
    fun calcularPerimetro() {
        val triangulo = Triangulo(6.0, 4.0)
        val perimetroEsperado = 6.0 * 3
        assertEquals(perimetroEsperado, triangulo.calcularPerimetro())
    }

}