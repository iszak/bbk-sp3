package mediator

class Button extends Colleague {
  def press(): Unit = {
    println("Button pressed.")
    mediator.start()
  }
}