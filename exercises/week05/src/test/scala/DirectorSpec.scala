import org.scalatest.FunSuite

class DirectorSuite extends FunSuite {
  test("that companion object apply returns new director") {
    val d = Director("Iszak", "Bryan", 1992)
    assert(d.name == "Iszak Bryan")
    assert(d.yearOfBirth == 1992)
  }

  test("that companion object older returns oldest director") {
    val d1 = Director("Iszak", "Bryan", 1992)
    val d2 = Director("Iszak", "Bryan", 1982)
    assert(Director.older(d1, d2) == d2)
    assert(Director.older(d2, d1) == d2)
  }

  test("that name returns a combined first name and last name") {
    val d = new Director("Iszak", "Bryan", 1992)
    assert(d.name == "Iszak Bryan")
  }
}
