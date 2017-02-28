package decorator

class GreenOlives(val pizza: Pizza) extends PizzaDecorator {
  private val price = 5.47

  def getDesc: String = pizza.getDesc + ", Green Olives (" + price + ")"

  def getPrice: Double = pizza.getPrice + price
}
