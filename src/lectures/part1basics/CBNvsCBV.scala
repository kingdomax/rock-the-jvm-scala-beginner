package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = { // same as called back function
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByName(System.nanoTime()) // call System.nanoTime() when calledByName invoked
  calledByValue(System.nanoTime()) // call System.nanoTime() inside calledByValue

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  // printFirst(infinite, 34)
  printFirst(34, infinite)
}
