package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // SHOCK!! how we can initiate abstract class
  // This is anonymous  class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahaha")
  }
  /*
    compiler will do this code behind the scene
    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahahahaha")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */
  println(funnyAnimal.getClass)

  // Anonymous class work on class aswell
  class Person(name: String) {
    def sayHi: Unit = println(s"Him my name is $name")
  }
  val jim = new Person("Jim") { // don't forget to pass
    override def sayHi: Unit = println(s"Hi my name is Jim")
  }
}
