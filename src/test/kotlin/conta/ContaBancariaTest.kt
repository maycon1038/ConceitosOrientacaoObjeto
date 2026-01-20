package conta

import Encapsulamento.ContaBancaria
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
class ContaBancariaTest {



    @Test
    @DisplayName("Deve retornar a agência da conta")
    fun getAgencia() {
        with(ContaBancaria("12345", "001", "João Silva")){
            Assertions.assertEquals("001", agencia)
        }

    }

    @Test
    @DisplayName("Deve alterar a agência da conta")
    fun setAgencia() {
       with(ContaBancaria("12345", "001", "João Silva")){
           apply {agencia = "002"  }
           Assertions.assertEquals("002", agencia)
       }

    }

    @Test
        @DisplayName("Deve retornar o titular da conta")
        fun getTitular() {
           with(ContaBancaria("12345", "001", "João Silva")){
            Assertions.assertEquals("João Silva", titular)
        }
    }

    @Test
    @DisplayName("Deve alterar o titular da conta")
    fun setTitular() {
              with(ContaBancaria("12345", "001", "João Silva")){
               apply {  titular = "Maria Santos" }
              Assertions.assertEquals("Maria Santos", titular)
        }

    }

    @Test
    @DisplayName("Deve retornar o saldo formatado em reais")
    fun getSaldoFormatado() {
        with(ContaBancaria("12345", "001", "João Silva")){
            depositar(1000.0)
            sacar(500.0)
            Assertions.assertEquals("R$ 500.0", getSaldoFormatado())
        }


    }

    @Test
    @DisplayName("Deve depositar valor na conta e aumentar o saldo")
    fun depositar() {
        with(ContaBancaria("12345", "001", "João Silva")){
            depositar(500.0)
            Assertions.assertEquals("R$ 500.0", getSaldoFormatado())
            depositar(250.0)
            Assertions.assertEquals("R$ 750.0", getSaldoFormatado())
        }




    }

    @Test
    @DisplayName("Deve sacar valor da conta quando houver saldo suficiente")
    fun sacar() {
        with(ContaBancaria("12345", "001", "João Silva")){
            depositar(1000.0)
            Assertions.assertTrue(sacar(500.0))
            Assertions.assertEquals(500.0, getSaldo())
            Assertions.assertFalse(sacar(600.0))
            Assertions.assertEquals(500.0, getSaldo())
        }



    }

}