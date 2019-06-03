package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n<=1) acc
    else trFact(n-1, n*acc)
  }
  val fact10 = trFact(10, 1)
  val fact11 = trFact(11)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  /*
    savePicture(800)
    Above will confuse compiler, 2 ways to solve this problem
    1. pass in every leading argument
    2. name the arguments
   */
  savePicture("bmp")
  savePicture(height = 600, width = 800, format = "bmp")
}
