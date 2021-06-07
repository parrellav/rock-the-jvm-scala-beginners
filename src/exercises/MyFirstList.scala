package exercises

import scala.language.postfixOps

abstract class MyFirstList {
  def head: Int
  def tail: MyFirstList
  def isEmpty: Boolean
  def add(n: Int): MyFirstList
  def printElements: String
  override def toString: String = s"[$printElements]"
}

//object EmptyList extends MyList {
//  override def head: Int = throw new NoSuchElementException
//  override def tail: MyList = throw new NoSuchElementException
//  override def isEmpty: Boolean = true
//  override def add(h: Int): MyList = new Cons(h, EmptyList)
//
//  override def printElements: String = ""
//}
//
//class Cons(val h: Int, val t: MyList) extends MyList {
//  override def head: Int = h
//  override def tail: MyList = t
//  override def isEmpty: Boolean = false
//  override def add(h: Int): MyList = new Cons(h, this)
//  override def printElements: String = {
//      if (tail.isEmpty) head.toString
//    else s"$head ${tail.printElements}"
//  }
//}
//
//object Test extends App {
//  val empty = EmptyList
//  val firstList = new Cons(1, new Cons(2, new Cons(3, empty)))
//  println(EmptyList isEmpty)
//  println(firstList isEmpty)
//  val updated = firstList.add(4)
//  println(updated.toString)
//
//}
