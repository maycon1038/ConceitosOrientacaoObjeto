package Heranca


// Classe base (open permite herança)
open class Animal(val nome: String, val idade: Int) {
    open fun emitirSom() {
        println("$nome faz algum som")
    }

    open fun mover() {
        println("$nome está se movendo")
    }

    fun dormir() {
        println("$nome está dormindo")
    }
}

