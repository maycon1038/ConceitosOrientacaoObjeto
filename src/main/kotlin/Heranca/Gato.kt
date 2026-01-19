package Heranca


// Herança com propriedades adicionais
class Gato(nome: String, idade: Int, val pelagem: String) : Animal(nome, idade) {
    override fun emitirSom() {
        println("$nome diz: Miau!")
    }

    override fun mover() {
        println("$nome está andando silenciosamente")
    }
}