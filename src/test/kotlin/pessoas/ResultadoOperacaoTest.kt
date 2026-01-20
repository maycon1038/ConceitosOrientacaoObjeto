package pessoas

import Abstracao.ResultadoOperacao
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

class ResultadoOperacaoTest {
    @Test
    @DisplayName("Deve retornar sucesso quando operação for bem-sucedida")
    fun sucesso() {
        val resultado = ResultadoOperacao.Sucesso("Operação realizada com sucesso", 200)

        assertTrue(resultado is ResultadoOperacao.Sucesso)
        assertEquals("Operação realizada com sucesso", resultado.mensagem)
        assertEquals(200, resultado.codigo)
    }

}