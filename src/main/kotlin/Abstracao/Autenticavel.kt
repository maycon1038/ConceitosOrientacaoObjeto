package Abstracao

// Interfaces para abstração adicional
interface Autenticavel {
    val senha: String
    fun autenticar(senha: String): Boolean
}