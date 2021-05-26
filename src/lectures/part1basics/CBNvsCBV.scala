package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long) = {
    println(f"by value: $x")
    println(f"by value: $x")
  }

  def calledByName(x: => Long) = {
    println(f"by name: $x")
    println(f"by name: $x")
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34) causes a crash
  printFirst(34, infinite()) // works because the call by name delays evaluation
}
