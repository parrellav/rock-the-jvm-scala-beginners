package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x = 42
  println(x)

  // VALS ARE IMMUTABLE
  // COMPILER CAN INFER TYPES

  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'b'
  val anInt: Int = x
  val aShort: Short = 4613 //4 bytes
  val aLong: Long = 655362341361361346L // 8 bytes
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables (can be reassigned)
  var aVariable: Int = 4
  aVariable = 5
}
