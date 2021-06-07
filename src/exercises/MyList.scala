package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def printElements: String
  override def toString: String = s"[$printElements]"
  def map[B](transformer: A => B): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def ++[B >: A](list: MyList[B]):  MyList[B]
}

object EmptyList extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](n: B): MyList[B] = new Cons(n, EmptyList)
  override def printElements: String = ""
  override def map[B](transformer: Nothing => B): MyList[B] = EmptyList
  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = EmptyList
  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = EmptyList
  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](n: B): MyList[B] = new Cons(n, this)
  override def printElements: String = {
    if (tail.isEmpty) head.toString
    else s"$head ${tail.printElements}"
  }

  override def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(head), t.map(transformer))
  }

  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(head)) new Cons(head, tail.filter(predicate))
    else tail.filter(predicate)
  }

  /*
  (1,2) ++ (3,4,5)
  new Cons(1, [2]) ++ (3,4,5)
  new Cons(1, new Cons(2, Empty) ++ (3,4,5)
  new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
   */
  override def ++[B >: A](list: MyList[B]):  MyList[B] = new Cons(head, tail ++ list)
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(head) ++ tail.flatMap(transformer)
  }
}

object TestGenericList extends App {
  val empty = EmptyList
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Hi", new Cons("How are you?", empty)))
  println(listOfIntegers)
  println(listOfStrings)
  println(listOfIntegers.map(_* 2))

  println(listOfIntegers.filter(_ % 2 == 0))

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(from => new Cons(from, new Cons(from + 1, EmptyList))))
}
