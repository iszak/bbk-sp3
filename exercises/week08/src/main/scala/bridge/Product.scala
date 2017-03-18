package bridge

trait Product {
  def productName: String

  def produce = println(s"Producing $productName")
}