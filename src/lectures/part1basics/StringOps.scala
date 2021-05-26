package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)

  val aNumberString: String = "2"
  val aNumber: Int = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')

  println(str.take(2))

  // Scala specific String interpolators

  //S-interpolators
  val name = "Vinny"
  val age = 40
  val greeting = s"Hello, my name is $name and I am $age years old."
  val greeting2 = s"Hello, my name is $name and I am ${age + 1} years old."

  //F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw interpolators
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
