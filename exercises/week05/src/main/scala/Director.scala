object Director {
  def older(d1: Director, d2: Director) = d1 match {
    case x if d1.yearOfBirth < d2.yearOfBirth => d1
    case y if d1.yearOfBirth > d2.yearOfBirth => d2
    // TODO: Handle same
    case _ => d1
  }
}

case class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name = firstName + " " + lastName
}
