name := """Coursework One - Simple Machine Language"""

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)
