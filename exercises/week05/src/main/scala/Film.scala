class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge =  yearOfRelease - director.yearOfBirth
  def isDirectedBy(d: Director) = d == director

  def copy(
    name:String = name,
    yearOfRelease: Int = yearOfRelease,
    imdbRating: Double = imdbRating,
    director: Director = director
  ): Film = new Film(name, yearOfRelease, imdbRating, director)
}

