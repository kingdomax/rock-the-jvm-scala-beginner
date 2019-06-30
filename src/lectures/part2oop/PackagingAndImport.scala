package lectures.part2oop

import playground.{Cinderella, PrinceCharming}
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImport extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJvm", 2018)

  // import the package
  val princess = new Cinderella
  val princess2 = new playground.Cinderella

  // packages are in hierarchy
  // matching folder structure

  // package object (rarely used)
  sayHello
  println(SPEED_OF_LIGHT)

  // imports second one
  val princeCharming = new PrinceCharming

  // name conflict, solving as nam alias
  val date = new Date
  val sqlDate =  new SqlDate(2018,5,4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef = println(, ???)
}
