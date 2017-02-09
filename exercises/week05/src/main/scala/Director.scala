object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int) = new Director(firstName, lastName, yearOfBirth)

  def older(d1: Director, d2: Director) = {
    // TODO: What about same age
    // TODO: Maybe using pattern matching?
    if (d1.yearOfBirth < d2.yearOfBirth) {
      d1
    } else {
      d2
    }
  }
}

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name = firstName + " " + lastName

  // TODO: Ideally define equals method since we can't use a case class
}
