package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // when you need loops, use tail recursion

  /*
  1. Concatenate a string n times
  2. IsPrime function using tail recursion
  3. Fibonnaci function, tail recursive
   */

  @tailrec
  def concatenateTailRec(aString: String, acc: String, times: Int): String = {
    if (times <= 0) acc
    else concatenateTailRec(aString, acc + aString, times - 1)
  }

  println(concatenateTailRec("bob", "", 3))

  def isPrimeTailRec(n: Int): Boolean = {
    @tailrec
    def isPrime(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrime(t-1, (n % t) != 0 && isStillPrime)
    }
    isPrime(n/2, true)
  }

  println(isPrimeTailRec(2003))
  println(isPrimeTailRec(4))

  def fibonnaciTailRec(n:Int): Int = {
    @tailrec
    def _fibTr(i:Int, last:Int, lastLast:Int): Int = {
      if (i >= n) last
      else _fibTr(i+1, last + lastLast, last)
    }
    if (n <= 2) 1
    else _fibTr(2, 1, 1)
  }

  println(fibonnaciTailRec(8)) // 1 1 2 3 5 8 13 21

}
