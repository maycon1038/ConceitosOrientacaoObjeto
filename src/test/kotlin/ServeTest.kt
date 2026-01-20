import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

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
    return outputStream.toString().replace("\r\n", "\n")
}


class ServeTest {
    @Test
    @DisplayName("Deve inicializar o serviço corretamente")
    fun initServe() {
        val serve = Serve()
        val output = captureOutput {
            serve.initServe()
        }

        assertEquals("Conexão aberta\n", output)
    }
}