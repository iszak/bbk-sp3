object Counter {
  def apply(n: Int) = new Counter(n)
}

class Counter (n:Int) {
  def inc = Counter(n + 1)
  def dec = Counter(n - 1)
  def count = n
}
