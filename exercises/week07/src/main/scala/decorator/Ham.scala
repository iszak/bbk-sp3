package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator {
  private val price = 18.12

  def getDesc: String = pizza.getDesc + ", Ham (" + price + ")"

  def getPrice: Double = pizza.getPrice + price
}
