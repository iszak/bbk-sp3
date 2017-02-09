import org.scalatest.FunSuite

class DirectorSuite extends FunSuite {
  test("that name returns a combined first name and last name") {
    val d = new Director("Iszak", "Bryan", 1992)
    assert(d.name == "Iszak Bryan")
  }
}
