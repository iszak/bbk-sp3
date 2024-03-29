object Person {
  def apply(name: String) =  {
    val parts = name.split(" ")

    new Person(parts(0), parts(1))
  }
}

case class Person(val firstName: String, val lastName: String)
