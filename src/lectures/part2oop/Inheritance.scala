package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("nomnom")
  }
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  // access modifier
  val cat = new Cat
  // cat.eat inaccessible
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding + super
  class Dog(override val creatureType: String) extends Animal {

    // override val creatureType = "domestic" , we can override field in constructor

    override def eat(): Unit = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog creatureType)

  // type substitution
  val unknownAnimal: Animal = new Dog("K9") // polymorphism
  unknownAnimal.eat

  // how to preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in this file  only
}
