package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // class params are promoted to fields

  val jim = new Person("Jim", 34)
  println(jim.age)

  //sensible toString
  println(jim)

  //equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)

  println(jim == jim2)

  // handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //case classes have companion objects
  val thePerson = Person
  val mary = new Person("Mary", 23)

  //serializable!
  // important for akka

  //extractor patterns which can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The United Kingdom of Great Britain and Northern Ireland"
  }


}
