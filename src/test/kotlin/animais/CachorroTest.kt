package animais

import Heranca.Cachorro
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CachorroTest {

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
    @DisplayName("Deve emitir som 'Au Au!' quando o cachorro emitir som")
    fun emitirSom() {
        val cachorro = Cachorro("Rex", 3, "Labrador")

        val output = captureOutput {
            cachorro.emitirSom()
        }

        assertEquals(
            "Rex diz: Au Au!\n",
            output
        )

        // Verificar que o método executa sem erros
    }

    @Test
    @DisplayName("Deve abanar o rabo quando o método abanarRabo for chamado")
    fun abanarRabo() {
        val cachorro = Cachorro("Rex", 3, "Labrador")


        val output = captureOutput {
            cachorro.abanarRabo()
        }

        assertEquals(
            "Rex está abanando o rabo\n",
            output
        )
        // Verificar que o método executa sem erros
    }

    @Test
    @DisplayName("Deve retornar a raça correta do cachorro")
    fun getRaca() {
        val cachorro = Cachorro("Rex", 3, "Labrador")
        assertEquals("Labrador", cachorro.raca)
    }

}