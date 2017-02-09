object Film {
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) = new Film(name, yearOfRelease, imdbRating, director)

  def highestRating(f1: Film, f2: Film) = {
    // TODO: Same rating (epsilon) and pattern matching
    if (f1.imdbRating > f2.imdbRating) {
      f1
    } else {
      f2
    }
  }

  def oldestDirectorAtTheTime(f1: Film, f2: Film) = {
    // TODO: Same rating (epsilon) and pattern matching
    if (f1.directorsAge > f2.directorsAge) {
      f1.director
    } else {
      f2.director
    }
  }
}

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge =  yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: Director) = d == director

  def copy(
    name:String = name,
    yearOfRelease: Int = yearOfRelease,
    imdbRating: Double = imdbRating,
    director: Director = director
  ): Film = new Film(name, yearOfRelease, imdbRating, director)

  // TODO: Ideally use a equals method as we can't use case class
}

