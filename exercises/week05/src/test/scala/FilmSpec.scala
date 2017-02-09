import org.scalatest.FunSuite

class FilmSuite extends FunSuite {
  test("that companion object apply returns new film") {
    val d = new Director("John", "Carpenter", 1948)
    val f = Film("The Thing", 1982, 8.2, d)

    assert(f.name == "The Thing")
    assert(f.yearOfRelease == 1982)
    assert(f.imdbRating == 8.2)
    assert(f.director == d)
  }

  test("that companion object should return the oldest director at the time") {
    val d1 = new Director("John", "Carpenter", 1948)
    val d2 = new Director("Matthijs", "Heijningen", 1965)
    val f1 = Film("The Thing", 1982, 8.2, d1)
    val f2 = Film("The Thing", 2011, 6.2, d2)

    assert(Film.oldestDirectorAtTheTime(f1, f2) == d2)
    assert(Film.oldestDirectorAtTheTime(f2, f1) == d2)
  }

  test("that companion object highest rating returns best film") {
    val f1 = Film("The Thing", 1982, 8.2, new Director("John", "Carpenter", 1948))
    val f2 = Film("The Thing", 2011, 6.2, new Director("Matthijs", "Heijningen", 1965))

    assert(Film.highestRating(f1, f2) == f1)
    assert(Film.highestRating(f2, f1) == f1)
  }

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
