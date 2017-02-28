package decorator

class Spinach(val pizza: Pizza) extends PizzaDecorator {
  private val price = 7.92

  def getDesc: String = pizza.getDesc + ", Spinach (" + price + ")"

  def getPrice: Double = pizza.getPrice + price
}
