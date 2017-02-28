package decorator

class Cheese(val pizza: Pizza) extends PizzaDecorator {
  private val price = 20.72

  def getDesc: String = pizza.getDesc + ", Cheese (" + price + ")"

  def getPrice: Double = pizza.getPrice + price
}
