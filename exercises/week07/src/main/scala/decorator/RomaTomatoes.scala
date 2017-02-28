package decorator

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator {
  private val price = 5.20

  def getDesc: String = pizza.getDesc + ", Roma Tomatoes (" + price + ")"

  def getPrice: Double = pizza.getPrice + price
}
