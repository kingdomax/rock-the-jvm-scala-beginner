package lectures.part2oop

object AbstractDataTypes  extends App {

  // Abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // Trait
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // Trait vs Abstract class
  // 1. - traits do not have constructor parameters
  // 2. - 1 class can extends only 1 abstract but many traits
  // 3. - traits = behavior, abstract class = type of things
}
