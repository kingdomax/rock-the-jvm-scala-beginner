package lectures.part1basics

object Expressions extends App {

  // EXPRESSION
  val x: Int = 1 + 2

  println(2 + 3 * 4) // Mathematical expression + - * / & | ^ << >> >>> (right shift with zero extension)
  println(1 == x) // Comparable == != > >= < <=
  println(!(1 == x)) // Logical ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... side effects

  // Instructions (DO SOMETHING) vs Expressions (GIVE ME VALUE)
  // Instructions (think Java), expressions are evaluated (Scala)
  // Everything in Scala is an Expression!
  val aCondition: Boolean = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF expression
  println(aConditionedValue)

  // Side effects: print(), whiles, reassigning

  // NEVER WRITE THIS AGAIN (this is imperative code)
  var i: Int = 0
  val aWhile: Unit = while (i < 10) {
    println(i)
    i += 1
  }

  // Side effects: print(), whiles, reassigning
  val aWeirdValue: Unit = aVariable = 3 // Unit === void
  println(aWeirdValue)

  // Code blocks
  val aCodeBlock: String = {
    val y: Int = 2
    val z: Int = y + 1

    if (z > 2) "hello" else "goodbye" // last line gonna be return type
  }

  // EXERCISE
  // 1. difference between "hello world" vs println("hello world") ?
  //    return type is different
  // 2.
  val someValue = 2 < 3
  val someOtherValue = {
    if(someValue) 239 else 986 // irrelevant
    42
  }
  println(someOtherValue)
}
