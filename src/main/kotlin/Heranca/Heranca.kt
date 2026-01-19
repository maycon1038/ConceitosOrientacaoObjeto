package Heranca

/*Herança: Permite criar classes derivadas a partir de classes base
* Usamos ":" e "open/override" para herdar e sobrescrever */


fun main() {
 //   val animal = Animal("Genérico", 5)
    val dog = Cachorro("Dog", 3, "Labrador")
    val cat = Gato("Cat", 2, "Preta")

   // animal.emitirSom()  // Genérico faz algum som
  //  dog.emitirSom()     // Rex diz: Au Au!
  //  dog.abanarRabo()    // Rex está abanando o rabo
  //  cat.emitirSom()     // Mimi diz: Miau!

    // Polimorfismo: tratar objetos diferentes como Animal
    val animais: List<Animal> = listOf(dog, cat)
    animais.forEach {
        it.emitirSom()
        it.mover()
    }
}