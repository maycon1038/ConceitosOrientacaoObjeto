package conta

import Encapsulamento.ContaBancaria
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
class ContaBancariaTest {



    @Test
    @DisplayName("Deve retornar a agência da conta")
    fun getAgencia() {
        val conta = ContaBancaria("12345", "001", "João Silva")
        Assertions.assertEquals("001", conta.agencia)
    }

    @Test
    @DisplayName("Deve alterar a agência da conta")
    fun setAgencia() {
        val conta = ContaBancaria("12345", "001", "João Silva")
        conta.agencia = "002"
        Assertions.assertEquals("002", conta.agencia)
    }

    @Test
        @DisplayName("Deve retornar o titular da conta")
        fun getTitular() {
            val conta = ContaBancaria("12345", "001", "João Silva")
            Assertions.assertEquals("João Silva", conta.titular)
    }

    @Test
    @DisplayName("Deve alterar o titular da conta")
    fun setTitular() {
        val conta = ContaBancaria("12345", "001", "João Silva")
        conta.titular = "Maria Santos"
        Assertions.assertEquals("Maria Santos", conta.titular)
    }

    @Test
    @DisplayName("Deve retornar o saldo formatado em reais")
    fun getSaldoFormatado() {
        val conta = ContaBancaria("12345", "001", "João Silva")
        conta.depositar(1000.0)
        conta.sacar(500.0)
        Assertions.assertEquals("R$ 500.0", conta.getSaldoFormatado())
    }

    @Test
    @DisplayName("Deve depositar valor na conta e aumentar o saldo")
    fun depositar() {
        val conta = ContaBancaria("12345", "001", "João Silva")
        conta.depositar(500.0)
        Assertions.assertEquals("R$ 500.0", conta.getSaldoFormatado())
        conta.depositar(250.0)
        Assertions.assertEquals("R$ 750.0", conta.getSaldoFormatado())
    }

    @Test
    @DisplayName("Deve sacar valor da conta quando houver saldo suficiente")
    fun sacar() {
        val conta = ContaBancaria("12345", "001", "João Silva")
        conta.depositar(1000.0)

        Assertions.assertTrue(conta.sacar(500.0))

        Assertions.assertEquals(500.0, conta.getSaldo())

        Assertions.assertFalse(conta.sacar(600.0))
        Assertions.assertEquals(500.0, conta.getSaldo())
    }

}