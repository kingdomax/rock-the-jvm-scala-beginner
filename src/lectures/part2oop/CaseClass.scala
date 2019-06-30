package lectures.part2oop

object CaseClass extends App {

  /*
    Scenario: equals, hasCode, toString
   */
  case class Person(name: String, age: Int)

  // 1. Promoted all class parameters to be fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. case class have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. case class have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. case class are serializable, sending messages through network
  // Akka

  // 7. case class have extractor patterns = can be used in PATTERN MATCHING

  // case object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NL"
  }

  /*
    Exercises = use case class and case objects in GenericList
   */
}
