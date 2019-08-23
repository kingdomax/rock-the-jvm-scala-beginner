package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length) <<< this will crash with null pointer exception

  // 1. Throwing and catching exceptions
  // val aWeirdValue = throw new NullPointerException
  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exception
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42
  }

  val potentialFail = try {
    // code that might throw
    getInt(true)
  } catch {
    case e: NullPointerException => 43
  } finally {
    // code that will get executed NO MATTER WHAT
    // finally block is optional and does not influence the return type of this expression
    println("finally")
  }

  // 3. How to define your own exceptions
  class MyException extends Exception
  val exceptions = new MyException
  throw exceptions

  /*
    EXERCISE
    1. Crash your program with an OutOfMemoryError
    2. Crash with StackOverflowException
    3. PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)

       Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x,y exceeds Int.MIN_VALUE)
        - MathCalculationException for division by 0
   */

  //val outOfMemoryError = Array.ofDim(Int.MaxValue)
  //def infinite: Int = 1 + infinite
  //val stackOverflowError = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  class PocketCalculator {

    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException()
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException()
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverflowException()
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException()
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException()
      else if (x < 0 && y > 0 && result > 0) throw new OverflowException()
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException()
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException()
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else  x / y
    }
  }
}
