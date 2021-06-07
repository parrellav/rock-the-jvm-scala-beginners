package lectures.part3fp

object WhatsAFunction extends App {

  // use and work with functions as first class elements
  // problem: we come from an OO world

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int) = element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  val intToStringConverter = new ((Int) => String) {
    override def apply(v1: Int): String = v1.toString
  }

  println(stringToIntConverter("4"))

  val stringConcatenator: (String, String) => String = (v1: String, v2: String) => v1 + v2

  println(stringConcatenator("joe", "bob"))

  val superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
