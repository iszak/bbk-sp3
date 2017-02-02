package functions

import functions.Funcs._
import org.scalatest.FunSuite

class FunctionsTestSuite extends FunSuite {
  // Basics
  test("Tail removes the first element") {
    assert(tail(List(1, 2, 3, 4)) == List(2, 3, 4))
  }
  test("Tail throws exception on empty list") {
    assertThrows[IllegalArgumentException] {
      tail(List())
    }
  }

  test("setHead changes the first element of the list") {
    assert(setHead(List("A", "B", "C"), "0") == List("0", "B", "C"))
  }
  test("setHead changes the first element of empty list") {
    assert(setHead(List(), "0") == List("0"))
  }

  test("drop removes only element from the front of the list") {
    assert(drop(List(1), 1) == List())
  }
  test("drop removes 1 element from the front of the list") {
    assert(drop(List(1,2,3), 1) == List(2,3))
  }
  test("drop removes N elements from the front of the list") {
    assert(drop(List(1, 2, 3), 2) == List(3))
  }
  test("drop removes all elements from the list") {
    assert(drop(List(1, 2, 3), 10) == List())
  }

  test("init removes the last element") {
    assert(init(List("A", "B", "C", "D")) == List("A", "B", "C"))
  }
  test("init removes the only element") {
    assert(init(List("A")) == List())
  }
  test("init throws exception on empty list") {
    assertThrows[IllegalArgumentException] {
      init(List())
    }
  }

  // Folding
  test("foldLeft computes the correct value") {
    assert(foldLeft(List("H", "e", "l", "l", "o"), "")(_ + _) == "Hello")
  }

  test("sum produces the correct sum") {
    assert(sum(List(1.0, 2.0, 3.0, -3.0, -2.0, -1.0)) == 0.0)
  }
  test("sum zero elements produces the zero sum") {
    assert(sum(List()) == 0.0)
  }

  test("product produces the correct product") {
    assert(product(List(1.0, 2.0, 3.0, 4.0, 5.0)) == 120.0)
  }
  test("product produces the correct product on empty product") {
    assert(product(List()) == 1)
  }

  test("length calculates the length") {
    assert(length("Hello".toList) == 5)
  }
  test("length calculates the length of an empty list") {
    assert(length(List()) == 0)
  }

  test("reverse reverses the list") {
    assert(reverse("Hello".toList) == "olleH".toList)
  }
  test("reverse reverses an empty list") {
    assert(reverse(List()) == List())
  }

  test("flatten flattens the nested list") {
    assert(flatten(List(List(1, 2, 3), List(4, 5, 6))) == List(1, 2, 3, 4, 5, 6))
  }

  // Map and Filter
  test("map creates a new list of the correct values") {
    assert(map((1 to 10).toList)(_ + 1) == (2 to 11).toList)
  }

  test("filter filters the list") {
    assert(filter((-5 to 5).toList)(_ > 0) == (1 to 5).toList)
  }

  test("flatMap maps and flattens") {
    assert(flatMap((1 to 5).toList)(x => (x to 5).toList) ==
      List(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5))
  }

  // Combined

  test("maxAverage calculates the max average") {
    val list = List(1.0, 2.0, 3.0, 4.0, 5.0).map(x => (x, x + 10))
    assert(maxAverage(list) == 13.0)
  }

  test("variance calculates the correct variance") {
    val v = variance(List(1.0, 2.0, 3.0, 4.0, 5.0))
    assert(v == 2.0, "If you got 2.5, you divided by the wrong thing, probably.")
  }
}
