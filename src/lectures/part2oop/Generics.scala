package lectures.part2oop

object Generics extends App {

  // GENERIC TRAIT
  trait MyTrait[A] {
  }

  // GENERIC CLASS
  class MyList[+A] {

    def add[B >: A](element: B): MyList[B] = ???

    /*
      A = Cat
      B = Dog = Animal
     */
  }

  class MyMap[Key, Value] // more than 1 type

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // GENERIC METHODS
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // VARIANCE PROBLEM
  // Cat extends Animal, does a list[Cat] extend list[Animal]
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1. YES = COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // can we do animalList.add(new Dog)
  // yes, but it means we are pollute

  // 2. NO = INVARIANCE
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! = CONTRAVARIANCE <<< new one
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // BOUNDED TYPES (generic type that allow in some type)
  // upper bound type, accept only subtype
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

  class Car

  // val newCage = new Cage(new Car) // generic type need proper bound type
  // lower bound type, accept only supertype
}
