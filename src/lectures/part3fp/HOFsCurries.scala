package lectures.part3fp

object HOFsCurries extends App {

  // wtf is this?
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // this is a Higher Order Function (HOF)
  // map, flatMap, filter are HOFs

  // function that applies another function n times over a given value
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x)))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // nTimesBetter(f, n) = x => f(f(f...(x)))
  // increment10 = nTimesBetter(plusOne, 10) = x => plusOne(plusOne(...(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n:Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // curried functions
  val superAdder: Int => (Int => Int) = (x:Int) => (y:Int) => x + y
}
