package Encapsulamento


/*Encapsulamento: Controla o acesso aos dados através de modificadores de visibilidade:*/
/*Usamos private, protected, internal e public para controlar acesso*/
// Uso
fun main() {
    val conta = ContaBancaria("12345", "001", "João Silva")
    conta.titular = "João"
    conta.depositar(1000.0)
    conta.sacar(500.0)
    println(conta.getSaldoFormatado()) // R$ 500.0
    // conta.saldo = 1000.0 // ERRO: privado!
}