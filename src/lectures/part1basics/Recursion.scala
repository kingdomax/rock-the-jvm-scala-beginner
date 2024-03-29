package lectures.part1basics
import scala.annotation.tailrec

object Recursion extends App {

  // NORMAL RECURSIVE, preserve value in intermediate stack call
  def factorial(number: Int): Int = {
    if (number == 1) 1
    else {
      println(s"Computing factorial of $number - I first need factorial of " +  (number-1))
      val result = number * factorial(number - 1)
      println(s"Computing factorial of $number")
      result
    }
  }
  factorial(10)
  // factorial(5000) 500th will blow stack overflow


  // TAIL RECURSIVE, scala don't need to preserve intermediate stack call
  // WHEN YOU NEED LOOPS, USE_TAIL_RECURSION
  def anotherFactorial(number: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x == 1) accumulator
      else factHelper(x-1, x * accumulator) // use recursive as the last expression
    }
    factHelper(number, 1)
  }
  println(anotherFactorial(5000))
  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(8, 8 * 9 * 10 * 1)
    = ....
    = factHelper(2, 3 * 4 * .....  * 10 * 1)
    = factHelper(2, 2 * 3 * 4 * .....  * 10 * 1)
    = 1 * 2 * 3 * 4 * ..... * 10
 */

  /*
    EXERCISE
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
   */

  def concatString(aString: String, n: Int): String = {
    @tailrec
    def concatHelper(x: Int, accumulator: String): String = {
      if (x <= 1) accumulator
      else concatHelper(x - 1, aString + accumulator)
    }
    concatHelper(n, aString)
  }
  println(concatString("moch", 3))

  def IsPrime(n: Int): Boolean = {

    def isPrimeCheck(divisor: Int): Boolean = n % divisor != 0

    @tailrec
    def isPrimeUntil(divisor: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (divisor == 1) true
      else isPrimeUntil(divisor - 1, isPrimeCheck(divisor) && isStillPrime)
    }

    isPrimeUntil(n / 2, isPrimeCheck(n/2))
  }
  println(IsPrime(2003))
  println(IsPrime(629))

  def fibonacci(number: Int): Int = {
    @tailrec
    def fibonacciHelper(i: Int, last: Int, nextToLast: Int): Int = {  // Because original implementation need 2 recursive
      if(i >= number) last
      else fibonacciHelper(i+1, last + nextToLast, last) // 1 1 2 3 5 8 13, 21
    }

    if (number <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }
  println(fibonacci(8))
}
