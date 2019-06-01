package lectures.part1basics

object Function extends App {

  def aFunction(a: String, b: Int): String = a + " " + b
  println(aFunction("hello", 3))

  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction)

  // WHEN YOU NEED LOOPS, USE RECURSION
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  /*
    EXERCISE
    1. A greeting function (name. age) => "Hi, my name is $name and I am $age yeats old"
    2. Factorial function 1 * 2 * 3 ...... * n
    3. A Fibonacci function
    f(1) = 1
    f(2) = 1
    f(n) = f(n-1) + f(n -2)
    4. Tests if a number is prime
   */

    def greeting(name: String, age: Int): String = s"Hi, my name is $name and I am $age years old"
    println(greeting("Moch", 26))

    def factorial(number: Int): Int = {
      if (number == 1) 1
      else number * factorial(number - 1)
    }
    println(factorial(5))

    def fibonacci(number: Int): Int = {
      if (number == 0) 0
      else if (number == 1 || number == 2) 1
      else fibonacci(number - 1) + fibonacci(number - 2)
    }
    println(fibonacci(8)) // 1 1 2 3 5 8 13 21  (1+1 = 2 in 3rd position)

    def isPrimeNumber(number: Int): Boolean = {
      def isPrimeUntil(divisor: Int): Boolean = {
        if (divisor <= 1) true
        else number % divisor != 0 && isPrimeUntil(divisor - 1)
      }
      isPrimeUntil(number / 2)
    }
    println(isPrimeNumber(37))
    println(isPrimeNumber(2003))
    println(isPrimeNumber(37 * 17))
    println(isPrimeNumber(2003 * 17))
}
