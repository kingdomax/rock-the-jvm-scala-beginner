package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {

    def isAlive: Boolean = true
    def likes(movie: String): Boolean = movie == favouriteMovie

    def learn(subject: String): String = s"$name learns $subject"
    def learnScala: String = this learn "Scala"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickName: String): Person = new Person(s"$name$nickName", favouriteMovie)

    def unary_! : String = s"$name, what the heck?!" // beware the space after method's name
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def apply(): String = s"Hi, my name is $name amd I like $favouriteMovie"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"
  }

  // INFIX NOTATION (syntactic sugar) = operator notation
  val mary = new Person("Mary", "Inception")
  println(mary likes "Inception") // work with method with 1 parameter
  println(mary.likes("Inception"))

  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))
  println(1 + 2)
  println(1.+(2)) // ALL OPERATORS ARE METHODS

  // PREFIX NOTATION, unary operator works with - + ! ~
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)

  // POSTFIX, available for method without parameter
  println(mary.isAlive)
  println(mary isAlive)

  // APPLY METHOD
  println(mary.apply())
  println(mary()) // equivalent

  /*
    EXERCISES
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
  */
  println((mary + "the rockstar")())

  /*
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age +1
        +mary => mary with the age incrementer
  */
  println((+mary).age)

  /*
    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation
  */
  println(mary learnScala)

  /*
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */
  mary(2)
}
