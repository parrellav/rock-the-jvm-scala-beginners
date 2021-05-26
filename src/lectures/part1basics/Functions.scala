package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParamaterListFunction(): Int = 42
  println(aParamaterListFunction())
  println(aParamaterListFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
    1. A greeting function for kids, (name, age) => "Hi my name is $name and I am $age years old"
    2. Factorial function - compute product of all numbers up to a given number
    3. Fibonacci function - 1, 1, 2, 3, 5
    4. Tests if a number is prime
   */

  def greeting(name: String, age: Int): Unit = println(f"Hi my name is $name and I am $age years old")

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n-1)
  }
  println(factorial(5))

  def fibonacci(n: Int): Int = {
    if (n < 2) n
    else fibonacci(n-1) + fibonacci(n-2)
  }
  println(fibonacci(8))

  def isPrime(n: Int): Boolean = (0 != n % 2) && (0 != n % 3)

  println(isPrime(5))

  def isPrimeCourse(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n / 2)
  }

  println(isPrimeCourse(37))
  println(isPrimeCourse(2003))
  println(isPrimeCourse(37 * 17))

}
