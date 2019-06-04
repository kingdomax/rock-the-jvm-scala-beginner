package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  println(person.age)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposture = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectation", 1861, author)
  println(novel.getAuthorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposture))

  val counter = new Counter
  counter.inc.print()
  counter.inc.inc.inc.print()
  counter.inc(10).print()
}

// class parameters are NOT FIELDS, unless you put val keyword
class Person(name: String, val age: Int) { // primary constructor

  // body
  val x = 2
  println("inside class")

  // method
  def greet(name: String): Unit = print(s"${this.name} says Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructor
  def this(name: String) = this(name, 0) // 2nd constructor
  def this() = this("John") // 3rd constructor
}

/*
  EXERCISES
  1. a Writer and Novel

  Writer: first name, surname, year
    - method fullname

   Novel: name, year of release, author
   - authorAge
   - isWrittenBy(author)
   - copy (new year of release) = new instance of Novel
*/

class Writer(firstName: String, surName: String, val year: Int) {

  def getFullName: String = s"$firstName$surName"
}

class Novel(name: String, releasedYear: Int, author: Writer) {

  def getAuthorAge: Int = releasedYear - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newReleasedYear: Int): Novel = new Novel(name, newReleasedYear, author)
}

/*
   2. Counter class
   - receives an int value
   - method return current count
   - method to increment / decrement => new Counter
   - overload inc/dec to receive an amount => new Counter
 */
class Counter(val count: Int = 0) {

  def inc: Counter = {
    println("incrementing")
    new Counter(count)        // immutability : MAIN CONCEPT OF SCALA !!!
  }
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec: Counter = {
    println("decreasing")
    new Counter(count-1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print(): Unit = println(count)
}
