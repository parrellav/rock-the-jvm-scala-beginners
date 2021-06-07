package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // lambas must be called with parens ()
  println(justDoSomething)
  println(justDoSomething())

  // curly braces
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // more syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  // MyList replace all function calls with lambdas
  // Rewrite specialAdder as an anonymous function

  val specialAdder = (x: Int) => (y: Int) => x + y // curried version
  println(specialAdder(2)(5))
}
