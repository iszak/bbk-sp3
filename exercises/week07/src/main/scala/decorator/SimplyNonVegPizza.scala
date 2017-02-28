package decorator

class SimplyNonVegPizza extends Pizza {
  private val price = 350

  def getDesc: String = "SimplyNonVegPizza (" + price + ")"

  def getPrice: Double = price
}
