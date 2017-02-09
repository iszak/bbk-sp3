object Counter {
  def apply(n: Int) = new Counter(n)
}

class Counter (n:Int) {
  def inc = Counter(n + 1)
  def inc(m: Int) = Counter(n + m)

  def dec = Counter(n - 1)
  def dec(m: Int) = Counter(n - m)

  def count = n
}
