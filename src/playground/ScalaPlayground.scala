package playground

object ScalaPlayground {

  println("Hello, Scala!")

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    // factory pattern
    def apply(mother: Person, fatber: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality
  }

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = new Person("mary")
  val john = new Person("john")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  // COMPANIONS PATTERNS
  val bobbie = Person(mary, john)
  println(bobbie.name)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
  def main(args: Array[String]): Unit = { } // if we did not extend App, we need to defind method main
}
