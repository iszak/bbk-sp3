import org.scalatest.FunSuite

class AdderSuite extends FunSuite {
  test("that adder sums the value") {
    val a = new Adder(10)
    assert(a.add(1) == 11)
  }
}
