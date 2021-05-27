package lectures.part2oop

object OOBasics extends App {

  val person = new Person
  println(person)

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge())

  val counter = new Counter(5)
  println(s"${counter.count}")
  println(counter.inc(5).count)
  println(counter.dec(5).count)
}

class Person

class Writer(val firstName: String, val surname: String, val year: Int) {
  def fullname: String = f"$firstName $surname"
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAge() = yearOfRelease - author.year
  def isWrittenBy(author: Writer): Boolean = author.equals(this.author)
  def copy(newReleaseYear: Int): Novel = new Novel(name, newReleaseYear, author)
}

class Counter(val count: Int) {
  def inc(): Counter = {
    println("incrementing")
    new Counter(count + 1)
  }
  def dec(): Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n<=0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if (n<=0) this
    else dec.dec(n-1)
  }
}