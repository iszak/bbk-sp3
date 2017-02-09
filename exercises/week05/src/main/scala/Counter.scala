case class Counter (n:Int) {
  def inc = this.copy(n + 1)
  def inc(m: Int) = this.copy(n + m)

  def dec = this.copy(n - 1)
  def dec(m: Int) = this.copy(n - m)

  def adjust(a: Adder) = this.copy(a.add(n))

  def count = n
}
