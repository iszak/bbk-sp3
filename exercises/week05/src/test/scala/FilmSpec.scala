import org.scalatest.FunSuite

class FilmSuite extends FunSuite {
  test("that is directed by correctly checks") {
    val d1 = new Director("John", "Carpenter", 1948)
    val d2 = new Director("Matthijs", "Heijningen", 1965)
    val f = new Film("The Thing", 1982, 8.2, d1)
    assert(!f.isDirectedBy(d2))
    assert(f.isDirectedBy(d1))
  }

  test("that directors age is correctly calculated") {
    val d = new Director("John", "Carpenter", 1948)
    val f = new Film("The Thing", 1982, 8.2, d)
    assert(f.directorsAge == 34)
  }

  test("that copy uses default parameters") {
    val d = new Director("John", "Carpenter", 1948)
    val f = new Film("The Thing", 1982, 8.2, d)
    val fCopy = f.copy()

    assert(f.name == fCopy.name)
    assert(f.yearOfRelease == fCopy.yearOfRelease)
    assert(f.imdbRating == fCopy.imdbRating)
    assert(f.director == fCopy.director)
  }

  test("that copy can override parameters") {
    val d = new Director("John", "Carpenter", 1948)
    val f = new Film("The Thing", 1982, 8.2, d)
    val fCopy = f.copy(name="The Thing (1982)", yearOfRelease=1992, imdbRating=9.2)

    assert(fCopy.name == "The Thing (1982)")
    assert(fCopy.yearOfRelease == 1992)
    assert(fCopy.imdbRating == 9.2)
    assert(fCopy.director == d)
  }
}
