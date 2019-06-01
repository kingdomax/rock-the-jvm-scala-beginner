package lectures.part1basics

object ValuesVariablesTypes extends App {

  // VALS ARE IMMUTABLE
  val anInt: Int = 42 // represent 4 bytes
  val aString: String = "hello"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aShort: Short = 4613 // represent 2 byte
  val aLong: Long = 5273985273895237L // represent 8 byte
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // VARIABLES
  var aVariable: Int = 4
  aVariable = 5 // side effects
  aVariable += 1
}
