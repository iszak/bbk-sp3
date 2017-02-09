import org.scalatest.FunSuite

class CounterSuite extends FunSuite {
  test("that counter can incremenet") {
    assert(Counter(0).inc.inc.inc.inc.count == 4)
  }

  test("that counter can count") {
    assert(Counter(0).dec.inc.inc.inc.dec.count == 1)
  }

  test("that counter can decrement") {
    assert(Counter(0).dec.dec.dec.dec.count == -4)
  }

  test("that counter increments returns new counter") {
    val counter1 = Counter(0)
    val counter2 = counter1.inc

    assert(counter1.count == 0)
    assert(counter2.count == 1)
  }

  test("that counter decrements returns new counter") {
    val counter1 = Counter(1)
    val counter2 = counter1.dec

    assert(counter1.count == 1)
    assert(counter2.count == 0)
  }
}
