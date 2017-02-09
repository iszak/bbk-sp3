import org.scalatest.FunSuite

class PersonSuite extends FunSuite {
  test("that companion object constructs a person correctly") {
    val person = Person("Iszak Bryan")
    assert(person.firstName == "Iszak")
    assert(person.lastName == "Bryan")
  }
}
