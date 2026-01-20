package formas

import Polimorfismo.Circulo
import Polimorfismo.Figura
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CirculoTest {


    @Test
    @DisplayName("Verifica o nome retornado pelo método getNome é 'Circulo'")
    fun getNome() {
        val circulo = Circulo(5.0)
        assertEquals(Figura.CIRCULO.name, circulo.nome)
    }

    @Test
    @DisplayName("Calcula a área do círculo usando o valor padrão de PI")
    fun calcularArea() {
        val circulo = Circulo(5.0)
        val areaEsperada = Math.PI * 5.0 * 5.0
        assertEquals(areaEsperada, circulo.calcularArea())
    }

    @Test
    @DisplayName("Calcula a área do círculo usando um valor customizado de PI")
    fun testCalcularArea() {
        val circulo = Circulo(5.0)
        val piCustomizado = 3.14
        val areaEsperada = piCustomizado * 5.0 * 5.0
        assertEquals(areaEsperada, circulo.calcularArea(piCustomizado))
    }

    @Test
    @DisplayName("Calcula o perímetro do círculo")
    fun calcularPerimetro() {
        val circulo = Circulo(5.0)
        val perimetroEsperado = 2 * Math.PI * 5.0
        assertEquals(perimetroEsperado, circulo.calcularPerimetro())
    }

    @Test
    @DisplayName("Verifica o raio do círculo")
    fun getRaio() {
        val circulo = Circulo(5.0)
        assertEquals(5.0, circulo.raio)
    }

}