object Film {
  def highestRating(f1: Film, f2: Film) = f1 match {
    case x if f1.imdbRating < f2.imdbRating => f2
    case y if f1.imdbRating > f2.imdbRating => f1
    // TODO: Handle same rating (epsilon)
    case _ => f1
  }

  def oldestDirectorAtTheTime(f1: Film, f2: Film) = f1 match {
    case x if f1.directorsAge < f2.directorsAge => f2.director
    case y if f1.directorsAge > f2.directorsAge => f1.director
    // TODO: Handle same
    case _ => f1.director
  }
}

case class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge =  yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: Director) = d == director

  def copy(
    name:String = name,
    yearOfRelease: Int = yearOfRelease,
    imdbRating: Double = imdbRating,
    director: Director = director
  ): Film = new Film(name, yearOfRelease, imdbRating, director)
}

