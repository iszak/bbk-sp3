package decorator

class SimplyVegPizza extends Pizza {
  private val price = 230

  def getDesc: String = "SimplyVegPizza (" + price + ")"

  def getPrice: Double = price
}
