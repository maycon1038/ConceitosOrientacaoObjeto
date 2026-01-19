package animais

import Heranca.Gato
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class GatoTest {


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
    @DisplayName("Deve emitir som 'Miau!' quando o gato emitir som")
    fun emitirSom() {
        val gato = Gato("Mimi", 2, "Preta")
        gato.emitirSom()
        // Verificar que o método executa sem erros
    }

    @Test
    @DisplayName("Deve mover silenciosamente quando o gato se mover")
    fun mover() {
        val gato = Gato("Mimi", 2, "Preta")


        val output = captureOutput {
            gato.mover()
        }

        assertEquals(
            "Mimi está andando silenciosamente\n",
            output
        )

        // Verificar que o método executa sem erros
    }

    @Test
    @DisplayName("Deve retornar a pelagem correta do gato")
    fun getPelagem() {
        val gato = Gato("Mimi", 2, "Preta")
        assertEquals("Preta", gato.pelagem)
    }

}
