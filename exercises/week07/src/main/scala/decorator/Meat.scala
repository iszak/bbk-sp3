package decorator

class Meat(val pizza: Pizza) extends PizzaDecorator {
  private val price = 14.25

  def getDesc: String = pizza.getDesc + ", Meat (" + price + ") "

  def getPrice: Double = pizza.getPrice + price
}
