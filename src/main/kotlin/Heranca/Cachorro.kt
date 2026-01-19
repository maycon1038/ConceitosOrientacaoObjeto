package Heranca

// Herança simples
class Cachorro(nome: String, idade: Int, val raca: String) : Animal(nome, idade) {
    // Sobrescrevendo método da classe pai
    override fun emitirSom() {
        println("$nome diz: Au Au!")
    }

    // Método específico da classe Cachorro
    fun abanarRabo() {
        println("$nome está abanando o rabo")
    }
}