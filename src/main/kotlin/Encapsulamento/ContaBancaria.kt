package Encapsulamento

class ContaBancaria {
    // Propriedade privada - só acessível dentro da classe
    private var saldo: Double = 0.0

    // Propriedade protegida - acessível na classe e subclasses
    protected var numeroConta: String = ""

    // Propriedade interna - acessível no mesmo módulo
    internal var agencia: String = ""

    // Público (padrão) - acessível de qualquer lugar
    var titular: String = ""

    constructor(numeroConta: String, agencia: String, titular: String){
        this.numeroConta = numeroConta
        this.agencia = agencia
        this.titular = titular
    }

    // Getter personalizado
    fun getSaldoFormatado(): String {
        return "R$ $saldo"
    }

    fun getSaldo(): Double {
        return saldo
    }

    // Métodos públicos para manipular saldo (controle de acesso)
    fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
            println("Depósito de R$ $valor realizado")
        }
    }

    fun sacar(valor: Double): Boolean {
        if (valor <= saldo) {
            saldo -= valor
            println("Saque de R$ $valor realizado")
            return true
        }
        println("Saldo insuficiente")
        return false
    }
}

