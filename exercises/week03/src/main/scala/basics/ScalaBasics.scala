package basics

/**
 * This is a singleton object containing the functions you need
 * to implement. Please make sure to read the documentation associated
 * with each function and provide a sensible implementation.
 */
object ScalaBasics {

  /**
   * Write a function called add that takes two Int parameters
   * and returns their sum.
   *
   * @param a operand a
   * @param b operand b
   * @return the sum
   */
  def add(a: Int, b: Int): Int = a + b

  /**
   * Write a function that returns the inclusive Range from start to end.
   *
   * HINT: Look at the Scaladoc for Int/RichInt to find the answer.
   *
   * @param start the start of the range
   * @param end the end of the range
   * @return the inclusive Range from start to end
   */
  def inRange(start: Int, end: Int): Range = start to end

  /**
   * Write a function that returns a Range of odd n odd integers starting at 1.
   *
   * HINT: Look at the Scaladoc for Int/RichInt to find the answer.
   *
   * @param n the number of odd integers in the range
   * @return a Range of odd integers, excluding the last add integer
   */
  def oddRange(n: Int): Range = 1 to (n, 2)

  /**
   * Write a function that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a while loop.
   * - You may use both immutable (val) and mutable (var) variables.
   * - You must use an if expression.
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minWhile(r: Array[Int]): Int = {
    var minValue = r.head

    var index = 1
    while (index < r.length) {
      val value = r(index)
      if (value < minValue) {
        minValue = value
      }

      index += 1
    }

    minValue
  }

  /**
   * Write a function that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for loop (not for comprehension).
   * - You may use both immutable (val) and mutable (var) variables.
   * - You may not use an if expression.
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minFor(r: Array[Int]): Int = {
    var minValue = r.head

    for (value <- r) {
      value < minValue match {
        case true => minValue = value
        case false =>
      }
    }

    minValue
  }

  /**
   * Write a function called minRecursive that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You may not use any loops.
   * - You may not use any mutable (var) or immutable (val) variables.
   *
   * HINT: You might want to look at the Scaladoc for Array to see some
   * useful methods you can use to solve this.
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minRecursive(r: Array[Int]): Int = {
    if (r.length == 1)
      r(0)
    else if (r(0) > r(1))
      minRecursive(r.drop(1))
    else
      minRecursive(Array(r(0)) ++ r.splitAt(2)._2)
  }

  /**
   * Return the base 36 equivalent of the BitInt b.
   *
   * HINT: Poke around Scaladoc to find a way of doing this in Scala.
   *
   * @param b a big integer
   * @return the base 36 equivalent
   */
  def base36(b: BigInt): String = b.toString(36)

  /**
   * Splits the String s in half.
   *
   * This function returns a tuple (f, e), where the f is the first
   * half of the string and e is the last half of the string.
   *
   * For example,
   *   splitInHalf("abcdef") => ("abc", "def")
   *   splitInFalf("abcde")  => ("ab", "cde")
   *
   * Your implementation must conform to the following rules:
   *
   * - You may not use any loops.
   * - You may not use recursion.
   * - You may not use any mutable (var) or immutable (val) variables.
   *
   * HINT: You might find something useful in the String and StringOps Scaladoc.
   *
   * @param s the string to split
   * @return the split string as a tuple
   */
  def splitInHalf(s: String): (String, String) = (s.substring(0, s.length / 2), s.substring(s.length / 2, s.length))

  /**
   * Determines if the given string s is a palindrome.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for comprehension.
   * - You may not use any other loops.
   * - You may not use any mutable (var) variables.
   *
   * You should normalize the string s before determining if
   * it is a palindrome. That is, you should not distinguish
   * between upper and lowercase, you should not consider
   * spaces, and you should eliminate the punctuation
   * characters . ? , ; ! - '.
   *
   * HINT: You should consult the Scaladoc for String and
   * StringOps to help you with your solution.
   *
   * @param s the potential palindrome
   * @return true if s is a palindrome; false otherwise
   */
  def isPalindrome(s: String): Boolean = {
    val s1 = s.toLowerCase.replaceAll("[.?,;!-' ]", "")

    val contains = (for (i <- 0 until s1.length / 2)
      yield s1(i) == s1(s1.length - 1 - i)
    ).contains(false)

    !contains
  }

  /**
   * You don't have to complete this one as we've removed it from the list 
   * of required functions.
   *
   * Sum the characters (as integers) provided as arguments to this method.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for loop
   * - You may use any mutable (var) variables.
   *
   * @param cc 0 or more characters
   * @return the sum of the ASCII integers corresponding with the character.
   */
  def sumChars(cc: Char*): Int = {
    var sum = 0
    for (c <- cc) {
      sum += c
    }
    sum
  }

  /**
   * Counts the number of space delimited words in the provided array of strings.
   *
   * This function takes an array of strings that represent lines in a text file.
   * This function must return a Map from String to Int where the String is a
   * word found across all lines and the Int is the number of times that word
   * was seen. For example:
   *
   * wordCount(Array("this is a sentence.", "this is a sentence too!"))
   *
   * would return
   *
   * Map("this" -> 2,
   *     "is" -> 2,
   *     "a" -> 2,
   *     "sentence." -> 1,
   *     "sentence" -> 1,
   *     "too!" -> 1)
   *
   * You may assume that all words are delimited by spaces. You need not worry
   * about punctuation. You can implement this however you wish.
   *
   * @param lines the lines of a text file
   * @return a map from words to the number of times that word was seen
   */
  def wordCounter(lines: Array[String]): Map[String, Int] = {
    val initialValue = Map[String, Int]()

    lines.foldLeft(initialValue)((currentValue, line) =>
      line.split(" ").foldLeft(currentValue)((currentValue, word) =>
        currentValue ++ Map[String, Int](word -> (currentValue.getOrElse(word, 0) + 1))
      )
    )
  }
}
